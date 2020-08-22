package TossStrangeCoins;

/**
 * You have some coins.  The i-th coin has a probability prob[i] of facing heads when tossed.
 *
 * Return the probability that the number of coins facing heads equals target if you toss every coin exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: prob = [0.4], target = 1
 * Output: 0.40000
 * Example 2:
 *
 * Input: prob = [0.5,0.5,0.5,0.5,0.5], target = 0
 * Output: 0.03125
 */
public class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        double[] dp = new double[target + 1];
        dp[0] = 1.0d;

        for (int i = 0;i < prob.length;++ i) {
            for (int j = Math.min(i + 1, target);j >= 0;-- j) {
                dp[j] = prob[i] * (j > 0 ? dp[j - 1] : 0) + (1 - prob[i]) * dp[j];
            }
        }

        return dp[target];
    }
}
