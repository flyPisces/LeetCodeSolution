package ScoreofParentheses;

import java.util.*;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:

 () has score 1
 AB has score A + B, where A and B are balanced parentheses strings.
 (A) has score 2 * A, where A is a balanced parentheses string.


 Example 1:

 Input: "()"
 Output: 1
 Example 2:

 Input: "(())"
 Output: 2
 Example 3:

 Input: "()()"
 Output: 2
 Example 4:

 Input: "(()(()))"
 Output: 6
 */
public class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0;i < S.length();++ i) {
            if (S.charAt(i) == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();

                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
