package ValidPerfectSquare;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False

 * Created by aoshen on 8/2/16.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long square = mid * mid;
            if (square == num) return true;
            else if (square < num) start = mid + 1;
            else end = mid - 1;
        }

        return false;
    }
}
