package NumberofSubstringsContainingAllThreeCharacters;

/**
 * Given a string s consisting only of characters a, b and c.
 *
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 *
 * Input: s = "aaacb"
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 *
 * Input: s = "abc"
 * Output: 1
 */
public class Solution {
    public int numberOfSubstrings(String s) {
        int[] dp = new int[3];

        int i = 0, result = 0;
        for (int j = 0;j < s.length();++ j) {
            ++ dp[s.charAt(j) - 'a'];

            while (dp[0] > 0 && dp[1] > 0 && dp[2] > 0) {
                -- dp[s.charAt(i ++) - 'a'];
            }

            result += i;
        }

        return result;
    }
}
