package PowerOfThree;

/**
 * Given an integer, write a function to determine if it is a power of three.

    Follow up:
    Could you do it without using any loop / recursion?

    Credits:
    Special thanks to @dietpepsi for adding this problem and creating all test cases.
 * Created by aoshen on 4/5/16.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        double epsilon = 10e-15;

        double res = Math.log(n) / Math.log(3);

        return Math.abs(res - Math.round(res)) < epsilon;
    }
}
