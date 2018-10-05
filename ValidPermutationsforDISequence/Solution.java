package ValidPermutationsforDISequence;

/**
 * We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".)

 A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i:

 If S[i] == 'D', then P[i] > P[i+1], and;
 If S[i] == 'I', then P[i] < P[i+1].
 How many valid permutations are there?  Since the answer may be large, return your answer modulo 10^9 + 7.



 Example 1:

 Input: "DID"
 Output: 5
 Explanation:
 The 5 valid permutations of (0, 1, 2, 3) are:
 (1, 0, 3, 2)
 (2, 0, 3, 1)
 (2, 1, 3, 0)
 (3, 0, 2, 1)
 (3, 1, 2, 0)
 */
public class Solution {
    //https://leetcode.com/problems/valid-permutations-for-di-sequence/solution/
    public int numPermsDISequence(String S) {
        int N = S.length();
        int[][] dp = new int[N + 1][N + 1];
        dp[0][0] = 1;
        int MOD = (int)1e9 + 7;
        int result = 0;

        for (int i = 1;i <= N;++ i) {
            for (int j = 0;j <= i;++ j) {
                if (S.charAt(i - 1) == 'D') {
                    for (int k = j;k < i;++ k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                } else {
                    for (int k = 0;k < j;++ k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        for (int j = 0; j <= N; j++) {
            result += dp[N][j];
            result %= MOD;
        }

        return result;
    }
}
