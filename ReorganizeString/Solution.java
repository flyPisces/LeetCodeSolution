package ReorganizeString;

import java.util.PriorityQueue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters
 * that are adjacent to each other are not the same.

 If possible, output any possible result.  If not possible, return the empty string.

 Example 1:

 Input: S = "aab"
 Output: "aba"
 Example 2:

 Input: S = "aaab"
 Output: ""
 */
public class Solution {
    public String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[26];
        for (int i = 0;i < S.length();++ i) {
            dp[S.charAt(i) - 'a'] ++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int i = 0;i < 26;++ i) {
            if (dp[i] > 0) {
                pq.offer(new int[]{i, dp[i]});
            }
        }

        int[] pre = new int[] {-1, 0};
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (pre[1] > 0) {
                pq.offer(pre);
            }

            sb.append((char)(top[0] + 'a'));
            top[1] --;
            pre = top;
            if (pq.isEmpty() && pre[1] > 0) return "";

        }

        return sb.toString();
    }
}
