package DistinctSubsequencesII;

import java.util.Arrays;

/**
 *
 Given a string S, count the number of distinct, non-empty subsequences of S .

 Since the result may be large, return the answer modulo 10^9 + 7.



 Example 1:

 Input: "abc"
 Output: 7
 Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 Example 2:

 Input: "aba"
 Output: 6
 Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 Example 3:

 Input: "aaa"
 Output: 3
 Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 */
public class Solution {
    public int distinctSubseqII(String S) {
        long[] dp = new long[26];
        long MOD = (long)Math.pow(10, 9) + 7;
        for (Character c : S.toCharArray()) {
            dp[c - 'a'] = Arrays.stream(dp).sum() % MOD + 1;
        }

        return (int)(Arrays.stream(dp).sum() % MOD);
    }
}
