package PalindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Created by aoshen on 7/6/17.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;

        while (rev < x) {
            rev = 10 * rev + x % 10;
            x = x / 10;
        }

        return rev == x || x == rev / 10;
    }
}
