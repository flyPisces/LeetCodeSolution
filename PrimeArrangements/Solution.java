package PrimeArrangements;

import java.util.Arrays;

/**
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 *
 * (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
 *
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
 * Example 2:
 *
 * Input: n = 100
 * Output: 682289015
 */
public class Solution {
    public int numPrimeArrangements(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        isPrimes[1] = false;
        int primeNumber = 0;

        for (int i = 2;i <= n;++ i) {
            if (isPrimes[i]) {
                primeNumber ++;

                for (int j = 2;j * i <= n;++ j) {
                    isPrimes[j * i] = false;
                }
            }
        }

        int nonPrimeNumber = n - primeNumber;

        long ans = 1, MOD = 1_000_000_007;

        for (int i = primeNumber;i > 0;-- i) {
            ans = ans * i;
            ans = ans % MOD;
        }

        for (int i = nonPrimeNumber;i > 0;-- i) {
            ans = ans * i;
            ans = ans % MOD;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numPrimeArrangements(100));
    }
}
