package FractiontoRecurringDecimal;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 Hint:

 No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
 Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
 Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

 * Created by aoshen on 7/1/16.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;

        if (num == 0 || den == 0) {
            return "0";
        }

        boolean negative = false;
        if (num > 0 && den < 0) {
            negative = true;
        } else if (num < 0 && den > 0) {
            negative = true;
        }

        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> helper = new HashMap<>();

        num = Math.abs(num);
        den = Math.abs(den);
        long quotient = num / den;
        long remain = num % den;
        if (negative) sb.append("-");
        sb.append(quotient);

        int pos = 0;
        if (remain != 0) {
            helper.put(remain, pos);
            StringBuilder frac = new StringBuilder();

            while (remain != 0) {
                remain = remain * 10;
                frac.append(remain / den);
                remain = remain % den;

                if (helper.containsKey(remain)) {
                    String nonLoop = frac.substring(0, helper.get(remain));
                    String loop = frac.substring(helper.get(remain));

                    return sb.toString() + "." + nonLoop + "(" + loop + ")";
                }

                pos ++;
                helper.put(remain, pos);
            }

            return sb.toString() + "." + frac.toString();
        }

        return sb.toString();
    }
}
