package MiniParser;

import java.util.Stack;

/**
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Note: You may assume that the string is well-formed:

 String is non-empty.
 String does not contain white spaces.
 String contains only digits 0-9, [, - ,, ].
 Example 1:

 Given s = "324",

 You should return a NestedInteger object which contains a single integer 324.
 Example 2:

 Given s = "[123,[456,[789]]]",

 Return a NestedInteger object containing a nested list with 2 elements:

 1. An integer containing value 123.
 2. A nested list containing two elements:
 i.  An integer containing value 456.
 ii. A nested list with one element:
 a. An integer containing value 789.

 * Created by aoshen on 8/16/16.
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        String token = "";

        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(new NestedInteger());
                    break;
                case ']':
                    if (!token.isEmpty()) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(token)));
                    }
                    NestedInteger ni = stack.pop();
                    token = "";
                    if (!stack.isEmpty()) {
                        stack.peek().add(ni);
                    } else {
                        return ni;
                    }
                    break;
                case ',':
                    if (!token.isEmpty()) {
                        stack.peek().add(new NestedInteger(Integer.parseInt(token)));
                    }

                    token = "";
                    break;
                default:
                    token += c;
                    break;
            }
        }

        if (!token.isEmpty()) {
            return new NestedInteger(Integer.parseInt(token));
        }

        return null;
    }
}
