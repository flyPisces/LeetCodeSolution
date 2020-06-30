package MinimumFlipstoMakeaORbEqualtoc;

/**
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 *
 * Input: a = 2, b = 6, c = 5
 * Output: 3
 * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 * Example 2:
 *
 * Input: a = 4, b = 2, c = 7
 * Output: 1
 * Example 3:
 *
 * Input: a = 1, b = 2, c = 3
 * Output: 0
 */
public class Solution {
    public int minFlips(int a, int b, int c) {
        int result = 0;

        for (int i = 0;i < 32;++ i) {
            int aBit = (a >> i) & 1;
            int bBit = (b >> i) & 1;
            int cBit = (c >> i) & 1;

            if (cBit == 1 && aBit == 0 && bBit == 0) result += 1;
            else if (cBit == 0 && aBit == 1 && bBit == 1) result += 2;
            else if (cBit == 0 && !(aBit == 0 && bBit == 0)) result += 1;
        }

        return result;
    }
}
