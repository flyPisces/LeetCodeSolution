package PermutationinString;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False

 * Created by aoshen on 5/2/17.
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] dp = new int[26];

        for (int i = 0;i < len1;++ i) {
            dp[s1.charAt(i) - 'a']++;
            dp[s2.charAt(i) - 'a'] --;
        }

        if (allZeros(dp)) return true;

        for (int i = len1;i < len2;++ i) {
            dp[s2.charAt(i) - 'a'] --;
            dp[s2.charAt(i - len1) - 'a']++;

            if (allZeros(dp)) return true;
        }

        return false;
    }

    private boolean allZeros(int[] dp) {
        for (int num : dp) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
