package FindtheClosestPalindrome;

import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.

 The 'closest' is defined as absolute difference minimized between two integers.

 Example 1:
 Input: "123"
 Output: "121"
 Note:
 The input n is a positive integer represented by string, whose length will not exceed 18.
 If there is a tie, return the smaller one as answer.

 * Created by aoshen on 4/29/17.
 */
public class Solution {
    public String nearestPalindromic(String n) {
        if (n.length() >= 2 && allNine(n)) {
            String s= "1";
            for (int i = 0;i < n.length() - 1;++ i) {
                s += "0";
            }
            s += "1";

            return s;
        }

        boolean odd = (n.length() % 2 != 0);
        String left = n.substring(0, (n.length() + 1) / 2);
        long[] increments = {-1, 0, 1};

        String ret = n;
        long diff = Long.MAX_VALUE;
        for (long increment : increments) {
            String s = getPalindrome(Long.toString(Long.parseLong(left) + increment), odd);
            if (n.length() >= 2 && (s.length() != n.length() || Long.parseLong(s) == 0)) {
                s = "";
                for (int i = 0;i < n.length() - 1;++ i) {
                    s += "9";
                }
            }

            long d = s.equals(n) ? Long.MAX_VALUE : Math.abs(Long.parseLong(s) - Long.parseLong(n));
            if (d < diff) {
                diff = d;
                ret = s;
            }
        }

        return ret;
    }

    private String getPalindrome(String left, boolean odd) {
        String right = new StringBuilder(left).reverse().toString();
        return odd ? left.substring(0, left.length() - 1) + right : left + right;
    }

    private boolean allNine(String s) {
        for (int i = 0;i < s.length();++ i) {
            if (s.charAt(i) != '9') {
                return false;
            }
        }

        return true;
    }
}
