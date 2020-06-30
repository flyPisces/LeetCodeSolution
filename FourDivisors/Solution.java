package FourDivisors;

/**
 * Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.
 *
 * If there is no such integer in the array, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [21,4,7]
 * Output: 32
 * Explanation:
 * 21 has 4 divisors: 1, 3, 7, 21
 * 4 has 3 divisors: 1, 2, 4
 * 7 has 2 divisors: 1, 7
 * The answer is the sum of divisors of 21 only.
 */
public class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            int prev = 0;

            for (int d = 2;d * d <= num;++ d) {
                if (num % d == 0) {
                    if (prev == 0) {
                        prev = d;
                    } else {
                        prev = 0;
                        break;
                    }
                }
            }

            if (prev != 0 && prev != num / prev) {
                sum += 1 + num + prev + num / prev;
            }
        }

        return sum;
    }
}
