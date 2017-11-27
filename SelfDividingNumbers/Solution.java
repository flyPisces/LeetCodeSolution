package SelfDividingNumbers;

import java.util.*;

/**
 *
 A self-dividing number is a number that is divisible by every digit it contains.

 For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

 Also, a self-dividing number is not allowed to contain the digit zero.

 Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

 Example 1:
 Input:
 left = 1, right = 22
 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> results = new ArrayList<>();

        for (int i = left;i <= right;++ i) {
            int j = i;

            while (j > 0) {
                int mod = j % 10;

                if (mod == 0 || i % mod != 0) {
                    break;
                }

                j = j / 10;
            }

            if (j == 0) {
                results.add(i);
            }

        }

        return results;
    }
}
