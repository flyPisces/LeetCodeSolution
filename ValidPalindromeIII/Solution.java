package ValidPalindromeIII;

import java.util.Arrays;

/**
 * Given a string s and an integer k, find out if the given string is a K-Palindrome or not.
 *
 * A string is K-Palindrome if it can be transformed into a palindrome by removing at most k characters from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdeca", k = 2
 * Output: true
 * Explanation: Remove 'b' and 'e' characters.
 */
public class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int l = lsc(s);

        return (s.length() - l) <= k;
    }

    private int lsc(String s) {
        int N = s.length();

        int[][] dp = new int[N][N];

        for (int i = N - 1;i >= 0;-- i) {
            dp[i][i] = 1;
            for (int j = i + 1;j < N;++ j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][N - 1];
    }
}
