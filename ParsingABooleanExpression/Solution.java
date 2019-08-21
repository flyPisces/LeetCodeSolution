package ParsingABooleanExpression;

import java.util.*;

/**
 * Return the result of evaluating a given boolean expression, represented as a string.

 An expression can either be:

 "t", evaluating to True;
 "f", evaluating to False;
 "!(expr)", evaluating to the logical NOT of the inner expression expr;
 "&(expr1,expr2,...)", evaluating to the logical AND of 2 or more inner expressions expr1, expr2, ...;
 "|(expr1,expr2,...)", evaluating to the logical OR of 2 or more inner expressions expr1, expr2, ...


 Example 1:

 Input: expression = "!(f)"
 Output: true
 Example 2:

 Input: expression = "|(f,t)"
 Output: true
 Example 3:

 Input: expression = "&(t,f)"
 Output: false
 Example 4:

 Input: expression = "|(&(t,f,t),!(t))"
 Output: false
 */
public class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0;i < expression.length();++ i) {
            char c = expression.charAt(i);

            if (c == ')') {
                seen.clear();

                while (stack.peek() != '(') {
                    seen.add(stack.pop());
                }

                stack.pop();
                char symbol = stack.pop();

                if (symbol == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (symbol == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f');
                } else {
                    stack.push(seen.contains('f') ? 't' : 'f');
                }

            } else if (c != ',') {
                stack.push(c);
            }
        }

        return stack.pop() == 't';
    }
}
