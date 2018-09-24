package SuperPalindromes;

/**
 * Let's say a positive integer is a superpalindrome if it is a palindrome,
 * and it is also the square of a palindrome.

 Now, given two positive integers L and R (represented as strings),
 return the number of superpalindromes in the inclusive range [L, R].



 Example 1:

 Input: L = "4", R = "1000"
 Output: 4
 Explanation: 4, 9, 121, and 484 are superpalindromes.
 Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 */
public class Solution {
    public int superpalindromesInRange(String L, String R) {
        long left = Long.parseLong(L), right = Long.parseLong(R);
        int MAGIC = (int) Math.pow(10, 18 * 0.25);
        int ans = 0;

        for (int i = 1;i <= MAGIC;++ i) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 2;j >= 0;-- j) {
                sb.append(sb.charAt(j));
            }
            long val = Long.valueOf(sb.toString());
            val *= val;

            if (val > right) break;
            if (val >= left && isPalindrome(val)) ans ++;
        }

        for (int i = 1;i <= MAGIC;++ i) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 1;j >= 0;-- j) {
                sb.append(sb.charAt(j));
            }
            long val = Long.valueOf(sb.toString());
            val *= val;

            if (val > right) break;
            if (val >= left && isPalindrome(val)) ans ++;
        }

        return ans;
    }

    private boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    private long reverse(long x) {
        long result = 0;

        while (x > 0) {
            result = 10 * result + x % 10;
            x = x / 10;
        }

        return result;
    }
}
