package WildcardMatching;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "*") → true
    isMatch("aa", "a*") → true
    isMatch("ab", "?*") → true
    isMatch("aab", "c*a*b") → false
 *
 *  Created by aoshen on 4/26/16.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int indexs = 0;
        int indexp = 0;
        int indexStar = -1;
        int indexPrev = -1;

        while (indexs < s.length()) {
            if (indexp < p.length() && (p.charAt(indexp) == '?' || (s.charAt(indexs) == p.charAt(indexp)))) {
                indexp ++;
                indexs ++;
            } else if (indexp < p.length() && p.charAt(indexp) == '*') {
                indexStar = indexp;
                indexp ++;
                indexPrev = indexs;
            } else if (indexStar != -1) {
                indexp = indexStar + 1;
                indexPrev ++;
                indexs = indexPrev;
            } else {
                return false;
            }
        }

        while (indexp < p.length() && p.charAt(indexp) == '*') {
            indexp ++;
        }

        return indexp == p.length();
    }

    public boolean isMatchDP(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int j = 1;j <= pLen;++ j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1;i <= sLen;++ i) {
            for (int j = 1;j <= pLen;++ j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] | dp[i][j - 1] | dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLen][pLen];
    }

}
