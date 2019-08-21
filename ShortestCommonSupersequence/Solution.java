package ShortestCommonSupersequence;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Map;

/**
 * Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.

 (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)



 Example 1:

 Input: str1 = "abac", str2 = "cab"
 Output: "cabac"
 Explanation:
 str1 = "abac" is a substring of "cabac" because we can delete the first "c".
 str2 = "cab" is a substring of "cabac" because we can delete the last "ac".
 The answer provided is the shortest such string that satisfies these properties.
 */
public class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {
        int M = str1.length(), N = str2.length();

        int[][] dp = new int[M + 1][N + 1];

        for (int i = 0;i <= M;++ i) {
            for (int j = 0;j <= N;++ j) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = M - 1, j = N - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                sb.append(str1.charAt(i));
                -- i;
                -- j;
            } else {
                if (dp[i + 1][j] < dp[i][j + 1]) {
                    sb.append(str2.charAt(j));
                    -- j;
                } else {
                    sb.append(str1.charAt(i));
                    -- i;
                }
            }
        }

        while (i >= 0) {
            sb.append(str1.charAt(i));
            -- i;
        }

        while (j >= 0) {
            sb.append(str2.charAt(j));
            -- j;
        }

        return sb.reverse().toString();
    }
}
