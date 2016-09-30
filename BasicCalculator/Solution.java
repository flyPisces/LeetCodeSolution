package BasicCalculator;

import java.util.*;

/**
 *  Implement a basic calculator to evaluate a simple expression string.

    The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

    You may assume that the given expression is always valid.

    Some examples:
    "1 + 1" = 2
    " 2-1 + 2 " = 3
    "(1+(4+5+2)-3)+(6+8)" = 23

 *  Created by aoshen on 6/12/16.
 */
public class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        if (s == null || s.length() == 0) {
            return res;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < s.length();++ i) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int cur = c - '0';

                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = 10 * cur + s.charAt(++i) - '0';
                }

                res += sign * cur;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
                sign = 1;
            }
        }

        return res;
    }
}
