package SumOfSquareNumbers;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5
 Example 2:
 Input: 3
 Output: False

 * Created by aoshen on 7/5/17.
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        int left = 0, right = (int)Math.sqrt(c);

        while (left <= right) {
            int sum = left * left + right * right;

            if (sum < c) {
                left ++;
            } else if (sum > c) {
                right --;
            } else {
                return true;
            }
        }

        return false;
    }
}
