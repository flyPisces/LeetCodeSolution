package ReverseInteger;

/**
 * Reverse digits of an integer.

    Example1: x = 123, return 321
    Example2: x = -123, return -321
 * 
 * @author alshen
 *
 */

public class Solution {
    public int reverse(int x) {
        int newN = 0;
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }
        
        while (x != 0) {
            int left = x % 10;
            
            if ((Integer.MAX_VALUE - left) / 10 < newN) {
                return 0;
            }
            
            newN = 10 * newN + left;
            x = x / 10;
        }
        
        if (negative) {
            newN = -newN;
        }
        return newN;
    }
}
