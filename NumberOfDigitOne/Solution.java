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
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }
}
