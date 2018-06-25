package CountDifferentPalindromicSubsequences;

import java.util.*;

/**
 * Given a string S, find the number of different non-empty palindromic subsequences in S,
 * and return that number modulo 10^9 + 7.

 A subsequence of a string S is obtained by deleting 0 or more characters from S.

 A sequence is palindromic if it is equal to the sequence reversed.

 Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

 Example 1:
 Input:
 S = 'bccb'
 Output: 6
 Explanation:
 The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 Note that 'bcb' is counted only once, even though it occurs twice.
 Example 2:
 Input:
 S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 Output: 104860361
 Explanation:
 There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 */
public class Solution {
    private static final int div = 1000000007;

    /*public int countPalindromicSubsequences(String S) {
        TreeSet<Integer>[] characters = new TreeSet[26];
        for (int i = 0;i < 26;++ i) {
            characters[i] = new TreeSet<Integer>();
        }

        int len = S.length();

        Integer[][] dp = new Integer[len + 1][len + 1];

        for (int i = 0;i < len;++ i) {
            characters[S.charAt(i) - 'a'].add(i);
        }

        return memo(S, characters, dp, 0, len);
    }

    private int memo(String S, TreeSet<Integer>[] characters, Integer[][] dp, int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != null) return dp[start][end];

        long ans = 0;
        for (int i = 0;i < 26;++ i) {
            Integer new_start = characters[i].ceiling(start);
            Integer new_end = characters[i].lower(end);

            if (new_start == null || new_start >= end) continue;
            ++ ans;
            if (new_start != new_end) ++ ans;

            ans += memo(S, characters, dp, new_start + 1, new_end);
        }

        dp[start][end] = (int)ans % MOD;
        return dp[start][end];
    }*/

    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int mod = 1000000007;
        int[][][] dp = new int[4][n][n];

        for (int i = n-1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                for (int k = 0; k < 4; ++k) {
                    char c = (char) ('a' + k);
                    if (j == i) {
                        if (S.charAt(i) == c) dp[k][i][j] = 1;
                        else dp[k][i][j] = 0;
                    } else { // j > i
                        if (S.charAt(i) != c) dp[k][i][j] = dp[k][i+1][j];
                        else if (S.charAt(j) != c) dp[k][i][j] = dp[k][i][j-1];
                        else { // S[i] == S[j] == c
                            if (j == i+1) dp[k][i][j] = 2; // "aa" : {"a", "aa"}
                            else { // length is > 2
                                dp[k][i][j] = 2;
                                for (int m = 0; m < 4; ++m) { // count each one within subwindows [i+1][j-1]
                                    dp[k][i][j] += dp[m][i+1][j-1];
                                    dp[k][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int k = 0; k < 4; ++k) {
            ans += dp[k][0][n-1];
            ans %= mod;
        }

        return ans;
    }
}
