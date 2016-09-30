package CountPrimes;

/**
 * Description:

 Count the number of prime numbers less than a non-negative number, n.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.

 Hint:

 Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?

 * Created by aoshen on 8/15/16.
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] primes = new boolean[n];
        for (int i = 2;i < n;++ i) {
            primes[i] = true;
        }

        for (int i = 2;i <= Math.sqrt(n - 1);++ i) {
            if (primes[i]) {
                for (int j = i + i;j < n;j = j + i) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2;i < n;++ i) {
            if (primes[i])
                count ++;
        }

        return count;
    }
}
