package ReorderedPowerof2;

import java.util.Arrays;

/**
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

 Return true if and only if we can do this in a way such that the resulting number is a power of 2.



 Example 1:

 Input: 1
 Output: true
 Example 2:

 Input: 10
 Output: false
 Example 3:

 Input: 16
 Output: true
 Example 4:

 Input: 24
 Output: false
 Example 5:

 Input: 46
 Output: true
 */
public class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] target = count(N);

        for (int i = 0;i < 32;++ i) {
            int num = 1 << i;
            if (Arrays.equals(target, count(num))) {
                return true;
            }
        }

        return false;
    }

    private int[] count(int N) {
        int[] arr = new int[10];

        while (N > 0) {

            arr[N % 10] ++;
            N /= 10;
        }

        return arr;
    }
}
