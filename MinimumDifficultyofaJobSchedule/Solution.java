package MinimumDifficultyofaJobSchedule;

import java.util.Map;

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done in that day.
 *
 * Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */

public class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int N = jobDifficulty.length;
        if (N < d) return -1;

        int[][] dp = new int[d][N];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1;i < N;++ i) {
            dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
        }

        for (int i = 1;i < d;++ i) {
            for (int j = i;j < N;++ j) {
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = j;k >= i;-- k) {
                    localMax = Math.max(localMax, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k - 1] + localMax);
                }
            }
        }

        return dp[d - 1][N - 1];
    }
}
