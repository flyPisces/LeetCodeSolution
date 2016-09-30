package ValidParentheses;

import java.util.*;

/**
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    
 * @author alshen
 *
 */

public class Solution {
    
    public boolean isValid(String s) {
        
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0;i != s.length();++ i) {
            Character c = s.charAt(i);
            
            switch (c) {
            case '(':
            case '[':
            case '{':
                stack.push(c);
                break;
            case ')':
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
                break;
            case ']':
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
                break;
            case '}':
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
                break;
            }
        }
        
        return stack.size() == 0;
        
    }
}
