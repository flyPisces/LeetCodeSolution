package LongestPanlindromeSubstring;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 * @author alshen
 *
 */

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int start = 0;
        int end = 0;
        int len = s.length();
        int max = 0;
        
        boolean[][] arr = new boolean[len][len];
        
        for (int i = 0;i != len;++ i) {         
            for (int j = 0;j <= i;++ j) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || arr[j + 1][i - 1])) {
                    arr[j][i] = true;
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        
        return s.substring(start, end + 1);
    }
}
