package PalindromePermutation;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 * Created by aoshen on 7/9/16.
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) return false;

        int[] counts = new int[256];
        for (int i = 0;i < s.length();++ i) {
            counts[s.charAt(i)] ++;
        }

        int sum = 0;
        int odd_num = 0;

        for (int i = 0;i < 256;++ i) {
            sum += counts[i];
            if (counts[i] % 2 == 1) {
                odd_num ++;
            }
        }

        if (sum % 2 == 0) return odd_num ==0;

        return odd_num ==1;
    }
}
