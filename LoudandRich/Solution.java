package LoudandRich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money,
 * and different levels of quietness.

 For convenience, we'll call the person with label x, simply "person x".

 We'll say that richer[i] = [x, y] if person x definitely has more money than person y.
 Note that richer may only be a subset of valid observations.

 Also, we'll say quiet[x] = q if person x has quietness q.

 Now, return answer, where answer[x] = y if y is the least quiet person (that is,
 the person y with the smallest value of quiet[y]),
 among all people who definitely have equal to or more money than person x.


 Example 1:

 Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 Output: [5,5,2,5,4,5,6,7]
 Explanation:
 answer[0] = 5.
 Person 5 has more money than 3, which has more money than 1, which has more money than 0.
 The only person who is quieter (has lower quiet[x]) is person 7, but
 it isn't clear if they have more money than person 0.

 answer[7] = 7.
 Among all people that definitely have equal to or more money than person 7
 (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
 is person 7.

 The other answers can be filled out with similar reasoning.
 */
public class Solution {
    int[] dp;
    List<List<Integer>> lists;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N = quiet.length;
        dp = new int[N];
        Arrays.fill(dp, -1);

        lists = new ArrayList<>();
        for (int i = 0;i < N;++ i) {
            lists.add(new ArrayList<>());
        }

        for (int[] arr : richer) {
            lists.get(arr[1]).add(arr[0]);
        }

        for (int i = 0;i< N;++ i) {
            dfs(quiet, i);
        }

        return dp;
    }

    private int dfs(int[] quiet, int idx) {
        if (dp[idx] == -1) {
            dp[idx] = idx;
            List<Integer> list = lists.get(idx);

            for (Integer num : list) {
                int temp = dfs(quiet, num);
                if (quiet[dp[idx]] > quiet[temp]) {
                    dp[idx] = temp;
                }
            }
        }

        return dp[idx];
    }
}
