package PowerOfTwo;

/**
 * Given an integer, write a function to determine if it is a power of two.

    Credits:
    Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 * Created by aoshen on 4/5/16.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
