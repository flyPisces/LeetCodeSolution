package PalindromePartitioningIII;

import java.util.*;

/**
 * You are given a string s containing lowercase letters and an integer k. You need to :
 *
 * First, change some characters of s to other lowercase English letters.
 * Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
 * Return the minimal number of characters that you need to change to divide the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", k = 2
 * Output: 1
 * Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
 * Example 2:
 *
 * Input: s = "aabbc", k = 3
 * Output: 0
 * Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
 * Example 3:
 *
 * Input: s = "leetcode", k = 8
 * Output: 0
 */
public class Solution {

    Map<String, Integer> mapping = new HashMap<>();

    public int palindromePartition(String s, int k) {
        if (s.length() == k) return 0;

        int[][] dp = new int[k + 1][s.length() + 1];

        for (int i = 1;i <= s.length();++ i) {
            dp[1][i] = helper(s.substring(0, i));
        }

        for (int i = 2;i <= k;++ i) {
            for (int j = i;j <= s.length();++ j) {
                int min = Integer.MAX_VALUE;

                for (int m = i;m <= j;++ m) {
                    min = Math.min(dp[i - 1][m - 1] + helper(s.substring(m - 1, j)), min);
                }

                dp[i][j] = min;
            }
        }

        return dp[k][s.length()];
    }

    private int helper(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) return 0;

        if (mapping.containsKey(str)) return mapping.get(str);

        int result = 0;
        for (int i = 0;i < str.length();++ i) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) ++ result;
        }

        mapping.put(str, result / 2);

        return mapping.get(str);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.palindromePartition("tcymekt", 4));
    }
}
