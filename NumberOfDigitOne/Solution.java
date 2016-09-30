package NumberOfDigitOne;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 For example:
 Given n = 13,

 *
 * Created by aoshen on 5/20/16.
 */
public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;

        for (int m = 1;m <= n;m = m * 10) {
            int a = n / m;
            int b = n % m;

            ones = (a + 8) / 10 * m;
            if (a % 10 == 1) ones += b + 1;
        }

        return ones;
    }
}
