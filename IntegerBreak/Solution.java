package IntegerBreak;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: you may assume that n is not less than 2.
 *
 * Created by aoshen on 5/28/16.
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 3 || n == 2) {
            return n - 1;
        }

        int res = 1;
        while (n > 4) {
            res *= 3;
            n = n - 3;
        }
        res *= n;

        return res;
    }
}
