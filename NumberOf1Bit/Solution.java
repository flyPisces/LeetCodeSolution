package NumberOf1Bit;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

   For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 *
 * Created by aoshen on 4/2/16.
 */
public class Solution {
    int hammingWeight(int  n) {
        int numOf1Bit = 0;

        while (n != 0) {
            if ((n & 1) != 0) {
                ++ numOf1Bit;
            }

            n >>>= 1;
        }

        return numOf1Bit;
    }
}
