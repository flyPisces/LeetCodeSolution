package HappyNumber;

import java.util.*;

/**Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1

 * Created by aoshen on 7/1/16.
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)) {
            visited.add(n);

            n = getSumSquare(getDigits(n));
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int getSumSquare(int[] arr) {
        int sum = 0;

        for (int num: arr) {
            sum += num * num;
        }

        return sum;
    }

    private int[] getDigits(int n) {
        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add(n % 10);
            n = n / 10;
        }

        int[] arr = new int[list.size()];
        for (int i = 0;i < arr.length;++ i) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
