package MinimumNumberofTapstoOpentoWateraGarden;

import java.util.Arrays;

/**
 *
 There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

 There are n + 1 taps located at points [0, 1, ..., n] in the garden.

 Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

 Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 */
public class Solution {
    public int minTaps(int n, int[] ranges) {
        int result = 0;

        int[][] dp = new int[n + 1][2];
        for (int i = 0;i <= n;++ i) {
            dp[i][0] = i - ranges[i];
            dp[i][1] = i + ranges[i];
        }

        Arrays.sort(dp, (a, b) -> (a[0] - b[0]));

        for (int start = 0, end = 0, i = 0;i <= n && start < n;start = end, ++result) {
            while (i <= n && dp[i][0] <= start) {
                end = Math.max(dp[i][1], end);
                ++ i;
            }

            if (end <= start) return -1;
        }

        return result;
    }
}
