package MinimumFactorization;

import java.util.*;

/**
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

 If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.

 Example 1
 Input:

 48
 Output:
 68
 Example 2
 Input:

 15
 Output:
 35

 * Created by aoshen on 6/27/17.
 */
public class Solution {
    public int smallestFactorization(int a) {
        if (a < 10) return a;

        List<Integer> results = new ArrayList<>();
        for (int i = 9;i > 1;-- i) {
            while (a % i == 0) {
                results.add(i);
                a = a / i;
            }
        }

        if (a != 1) return 0;

        long result = 0;
        for (int i = results.size() - 1;i >= 0;-- i) {
            result = 10 * result + results.get(i);
            if (result > Integer.MAX_VALUE) return 0;
        }

        return (int) result;
    }
}
