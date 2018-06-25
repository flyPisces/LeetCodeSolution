package LargestSumofAverages;

/**
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?

 Note that our partition must use every number in A, and that scores are not necessarily integers.

 Example:
 Input:
 A = [9,1,2,3,9]
 K = 3
 Output: 20
 Explanation:
 The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
 We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 */
public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[][] dp = new double[N + 1][N + 1];

        double curr = 0;
        for (int i = 0;i < N;++ i) {
            curr += A[i];
            dp[i + 1][1] = curr / (i + 1);
        }

        return helper(N, K, A, dp);
    }

    private double helper(int n, int k, int[] A, double[][] dp) {
        if (dp[n][k] > 0) return dp[n][k];

        double curr = 0;
        for (int i = n - 1;i > 0;-- i) {
            curr += A[i];
            dp[n][k] = Math.max(dp[n][k], helper(i, k - 1, A, dp) + curr / (n - i));
        }

        return dp[n][k];
    }
}
