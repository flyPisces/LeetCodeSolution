package BreakAPalindrome;

/**
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.
 *
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Example 2:
 *
 * Input: palindrome = "a"
 * Output: ""
 *
 */
public class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        int N = palindrome.length();

        for (int i = 0;i < N / 2;++ i) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }

        arr[N - 1] = 'b';

        return N < 2 ? "" : String.valueOf(arr);
    }
}
