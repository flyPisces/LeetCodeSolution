package FactorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.

 *
 * Created by aoshen on 5/25/16.
 */
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        for (long i = 5;n / i >= 1;i = i * 5) {
            count += n / i;
        }

        return count;
    }
}
