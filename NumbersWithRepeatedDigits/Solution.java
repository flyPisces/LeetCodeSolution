package NumbersWithRepeatedDigits;

import java.util.*;

/**
 * Given a positive integer N, return the number of positive integers less than or equal to N that have at least 1 repeated digit.



 Example 1:

 Input: 20
 Output: 1
 Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
 Example 2:

 Input: 100
 Output: 10
 Explanation: The positive numbers (<= 100) with atleast 1 repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
 Example 3:

 Input: 1000
 Output: 262
 */
public class Solution {
    public int numDupDigitsAtMostN(int N) {
        List<Integer> digits = new ArrayList<>();

        for (int i = N + 1;i > 0;i = i / 10) {
            digits.add(0, i % 10);
        }

        int result = 0, n = digits.size();
        for (int i = 1;i < n;++ i) {
            result += 9 * helper(9, i - 1);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0;i < n;++ i) {
            for (int j = i > 0 ? 0 : 1;j < digits.get(i);++ j) {
                if (visited.contains(j)) continue;
                result += helper(9 - i, n - i - 1);
            }
            if (visited.contains(digits.get(i))) {
                break;
            }
            visited.add(digits.get(i));
        }

        return N - result;
    }

    private int helper(int m, int n) {
        return n == 0 ? 1 : helper(m, n - 1) * (m - n + 1);
    }
}
