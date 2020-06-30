package NumberofWaystoStayintheSamePlaceAfterSomeSteps;

/**
 * You have a pointer at index 0 in an array of size arrLen. At each step, you can move 1 position to the left, 1 position to the right in the array or stay in the same place  (The pointer should not be placed outside the array at any time).
 *
 * Given two integers steps and arrLen, return the number of ways such that your pointer still at index 0 after exactly steps steps.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: steps = 3, arrLen = 2
 * Output: 4
 * Explanation: There are 4 differents ways to stay at index 0 after 3 steps.
 * Right, Left, Stay
 * Stay, Right, Left
 * Right, Stay, Left
 * Stay, Stay, Stay
 * Example 2:
 *
 * Input: steps = 2, arrLen = 4
 * Output: 2
 * Explanation: There are 2 differents ways to stay at index 0 after 2 steps
 * Right, Left
 * Stay, Stay
 * Example 3:
 *
 * Input: steps = 4, arrLen = 2
 * Output: 8
 *
 */
public class Solution {
    public int numWays(int steps, int arrLen) {
        int MOD = 1_000_000_007;
        int COLS = steps / 2 + 2;
        int[][] dp = new int[steps][COLS];

        dp[0][0] = 1;
        if (steps > 1) dp[0][1] = 1;

        for (int i = 1;i < steps;++ i) {
            for (int j = 0;j < Math.min(arrLen, steps / 2 + 1);++ j) {
                int sum = 0;
                sum = (sum + (j > 0 ? dp[i - 1][j - 1] : 0)) % MOD;
                sum = (sum + dp[i - 1][j]) % MOD;
                sum = (sum + (j < arrLen - 1 ? dp[i - 1][j + 1] : 0)) % MOD;

                dp[i][j] = sum % MOD;
            }
        }

        return dp[steps - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numWays(3, 2));
    }
}
