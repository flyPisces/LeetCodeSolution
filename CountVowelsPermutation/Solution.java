package CountVowelsPermutation;

import java.util.Arrays;

/**
 * Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 * Example 2:
 *
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 * Example 3:
 *
 * Input: n = 5
 * Output: 68
 */
public class Solution {
    public int countVowelPermutation(int n) {
        long[][] dp = new long[2][5];

        Arrays.fill(dp[0], 1);

        long result = 0, MOD = 1_000_000_007;

        for (int i = 1;i < n;++ i) {
            dp[1][0] = (dp[0][1] + dp[0][2] + dp[0][4]) % MOD;
            dp[1][1] = (dp[0][0] + dp[0][2]) % MOD;
            dp[1][2] = (dp[0][1] + dp[0][3]) % MOD;
            dp[1][3] = dp[0][2];
            dp[1][4] = (dp[0][2] + dp[0][3]) % MOD;

            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
            dp[0][3] = dp[1][3];
            dp[0][4] = dp[1][4];
        }

        for (int i = 0;i < 5;++ i) {
            result = (result + dp[0][i]) % MOD;
        }

        return (int)result;
    }
}
