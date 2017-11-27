package MinimumWindowSubsequence;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

 If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

 Example 1:
 Input:
 S = "abcdebdde", T = "bde"
 Output: "bcde"
 Explanation:
 "bcde" is the answer because it occurs before "bdde" which has the same length.
 "deb" is not a smaller window because the elements of T in the window must occur in order.
 */
public class Solution {
    public String minWindow(String S, String T) {
        int[][] dp = new int[T.length()][S.length()];

        for (int i = 0;i < T.length();++ i) {
            for (int j = 0;j < S.length();++ j) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0;i < S.length();++ i) {
            if (T.charAt(0) == S.charAt(i)) {
                dp[0][i] = i;
            }
        }

        for (int j = 1;j < T.length();++ j) {
            int k = -1;

            for (int i = 0;i < S.length();++ i) {
                if (k != -1 && S.charAt(i) == T.charAt(j)) {
                    dp[j][i] = k;
                }
                if (dp[j - 1][i] != -1) {
                    k = dp[j - 1][i];
                }
            }
        }

        String result = "";

        int maxLen = Integer.MAX_VALUE;
        for (int i = 0;i < S.length();++ i) {
            if (dp[T.length() - 1][i] != - 1 && i - dp[T.length() - 1][i] + 1 < maxLen) {
                maxLen = i - dp[T.length() - 1][i] + 1;
                result = S.substring(dp[T.length() - 1][i], i + 1);
            }
        }

        return result;
    }
}
