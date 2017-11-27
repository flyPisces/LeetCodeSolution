package ValidParenthesisString;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid.
 *
 * We define the validity of a string by these rules:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')'
 or a single left parenthesis '(' or an empty string.

 An empty string is also valid.
 Example 1:
 Input: "()"
 Output: True
 Example 2:
 Input: "(*)"
 Output: True
 Example 3:
 Input: "(*))"
 Output: True
 */
public class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private boolean check(String s, int start, int count) {
        if (count < 0) return false;

        for (int i = start;i < s.length();++ i) {
            if (s.charAt(i) == '(') {
                count = count + 1;
            } else if (s.charAt(i) == ')') {
                if (count <= 0) return false;
                count = count - 1;
            } else if (s.charAt(i) == '*'){
                return check(s, i + 1, count + 1)  || check(s, i + 1, count - 1) ||
                        check(s, i + 1, count);
            }
        }

        return count == 0;
    }
}
