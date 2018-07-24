package PrimePalindrome;

/**
 * Find the smallest prime palindrome greater than or equal to N.

 Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.

 For example, 2,3,5,7,11 and 13 are primes.

 Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.

 For example, 12321 is a palindrome.



 Example 1:

 Input: 6
 Output: 7
 Example 2:

 Input: 8
 Output: 11
 Example 3:

 Input: 13
 Output: 101
 */
public class Solution {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;

        for (int i = 1;i < 100000;++ i) {
            String left = String.valueOf(i);
            String right = new StringBuilder(left).reverse().toString().substring(1);

            int j = Integer.parseInt(left + right);
            if (j >= N && isPrime(j)) return j;
        }

        return -1;
    }

    private boolean isPrime(int num) {
        if (num < 2 || num % 2 == 0) return num == 2;

        for (int i = 3;i * i <= num;i = i + 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
