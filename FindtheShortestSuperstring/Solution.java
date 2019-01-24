package FindtheShortestSuperstring;

import java.util.*;

/**
 *

 Given an array A of strings, find any smallest string that contains each string in A as a substring.

 We may assume that no string in A is substring of another string in A.


 Example 1:

 Input: ["alex","loves","leetcode"]
 Output: "alexlovesleetcode"
 Explanation: All permutations of "alex","loves","leetcode" would also be accepted.
 Example 2:

 Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
 Output: "gctaagttcatgcatc"
 *
 */
public class Solution {
    private int calc(String a, String b) {
        for (int i = 1;i < a.length();++ i) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }

        return b.length();
    }

    public String shortestSuperstring(String[] A) {
        int N = A.length;
        int[][] dp = new int[1 << N][N], graph = new int[N][N], path = new int[1 << N][N];

        for (int i = 0;i < N;++ i) {
            for (int j = 0;j < N;++ j) {
                graph[i][j] = calc(A[i], A[j]);
            }
        }

        int last = -1, min = Integer.MAX_VALUE;

        for (int i = 0;i < (1 << N);++ i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            for (int j = 0;j < N;++ j) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);

                    if (prev == 0) {
                        dp[i][j] = A[j].length();
                    } else {
                        for (int k = 0;k < A.length;++ k) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }

                if (i == (1 << N) - 1 && min > dp[i][j]) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int curr = (1 << N) - 1;
        while (curr > 0) {
            stack.push(last);
            int temp = curr;
            curr -= (1 << last);
            last = path[temp][last];
        }

        StringBuilder sb = new StringBuilder();

        int top = stack.pop();
        sb.append(A[top]);
        while (!stack.isEmpty()) {
            int newTop = stack.pop();
            sb.append(A[newTop].substring(A[newTop].length() - graph[top][newTop]));
            top = newTop;
        }


        return sb.toString();
    }
}
