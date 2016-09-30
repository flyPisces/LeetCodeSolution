package CountNumberswithUniqueDigits;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

 * Created by aoshen on 6/28/16.
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(n, 10);
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1;i <= n;++ i) {
            dp[i] = 9;
            for (int j = 9;j >= 9 - i + 2;-- j) {
                dp[i] *= j;
            }
        }

        int result = 0;
        for (int val : dp) {
            result += val;
        }

        return result;
    }
}
