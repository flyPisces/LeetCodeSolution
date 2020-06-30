package DiceRollSimulation;

/**
 * A die simulator generates a random number from 1 to 6 for each roll. You introduced a constraint to the generator such that it cannot roll the number i more than rollMax[i] (1-indexed) consecutive times.
 *
 * Given an array of integers rollMax and an integer n, return the number of distinct sequences that can be obtained with exact n rolls.
 *
 * Two sequences are considered different if at least one element differs from each other. Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2, rollMax = [1,1,2,2,2,3]
 * Output: 34
 * Explanation: There will be 2 rolls of die, if there are no constraints on the die, there are 6 * 6 = 36 possible combinations. In this case, looking at rollMax array, the numbers 1 and 2 appear at most once consecutively, therefore sequences (1,1) and (2,2) cannot occur, so the final answer is 36-2 = 34.
 * Example 2:
 *
 * Input: n = 2, rollMax = [1,1,1,1,1,1]
 * Output: 30
 * Example 3:
 *
 * Input: n = 3, rollMax = [1,1,1,2,2,3]
 * Output: 181
 */
public class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        long[][] dp = new long[n][7];
        long MOD = 1_000_000_007;

        for (int j = 0;j < 6;++ j) {
            dp[0][j] = 1;
        }
        dp[0][6] = 6;

        for (int i = 1;i < n;++ i) {
            long sum = 0;

            for (int j = 0;j < 6;++ j) {
                dp[i][j] = dp[i - 1][6];

                if (i < rollMax[j]) {
                    sum = (sum + dp[i][j]) % MOD;
                } else {
                    if (i - rollMax[j] - 1 >= 0) {
                        dp[i][j] = (dp[i][j] - (dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j] + MOD) % MOD + MOD) % MOD;
                    } else {
                        dp[i][j] = (dp[i][j] - 1 + MOD) % MOD;
                    }

                    sum = (sum + dp[i][j]) % MOD;
                }
            }

            dp[i][6] = sum;
        }

        return (int)dp[n - 1][6];
    }
}
