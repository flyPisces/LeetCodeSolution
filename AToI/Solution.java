package AToI;

/**
 * Implement atoi to convert a string to an integer.

    Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

    Update (2015-02-10):
    The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 */


public class Solution {
    public int myAtoi(String str) {
        // if it is empty or null, return 
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        // remove empty spaces
        str = str.trim();
        
        // get whether it is negative or positive
        boolean isNegative = false;
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1);
        } else if (str.charAt(0) == '+') {
            str = str.substring(1);
        }
        
        int res = 0;
        
        // check if there is invalid input or overflow
        for (int i = 0;i != str.length();++ i) {
            int diff = str.charAt(i) - '0';
            
            if (diff < 0 || diff > 9) {
                break;
            }
            
            if (isNegative) {
                if ((Integer.MIN_VALUE + diff) / 10 <= res ) {
                    res = 10 * res - diff;
                } else {
                    break;
                }
            } else {
                if ((Integer.MAX_VALUE - diff) / 10  >= res) {
                    res = 10 * res + diff;
                } else {
                    break;
                }
            }
        }
        
        return res;
    }
}
