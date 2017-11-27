package ValidPalindromeTwo;


/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();

        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return check(s, l, r + 1) || check(s, l - 1, r);
            }
        }

        return true;
    }

    private boolean check(String s, int l, int r) {
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }

        return true;
    }
}
