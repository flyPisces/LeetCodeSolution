package ReverseSubstringsBetweenEachPairofParentheses;

import java.util.*;

/**
 * Given a string s that consists of lower case English letters and brackets.
 *
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * Your result should not contain any bracket.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(abcd)"
 * Output: "dcba"
 * Example 2:
 *
 * Input: s = "(u(love)i)"
 * Output: "iloveu"
 * Example 3:
 *
 * Input: s = "(ed(et(oc))el)"
 * Output: "leetcode"
 * Example 4:
 *
 * Input: s = "a(bcdefghijkl(mno)p)q"
 * Output: "apmnolkjihgfedcbq"
 */

public class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                Queue<Character> list = new LinkedList<>();

                while (!st.isEmpty() && st.peek() != '(') {
                    list.add(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop();
                }

                while (!list.isEmpty()) {
                    st.push(list.remove());
                }
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
