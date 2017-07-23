package TernaryExpressionParser;

/**
 * Given a string representing arbitrarily nested ternary expressions,
 * calculate the result of the expression.
 *
 * You can always assume that the given expression is valid and only consists of digits 0-9, ?, :,
 * T and F (T and F represent True and False respectively).

 Note:

 The length of the given string is ≤ 10000.
 Each number will contain only one digit.
 The conditional expressions group right-to-left (as usual in most languages).
 The condition will always be either T or F. That is, the condition will never be a digit.
 The result of the expression will always evaluate to either a digit 0-9, T or F.
 Example 1:

 Input: "T?2:3"

 Output: "2"

 Explanation: If true, then result is 2; otherwise result is 3.
 Example 2:

 Input: "F?1:T?4:5"

 Output: "4"

 Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

 "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 -> "4"                                    -> "4"
 Example 3:

 Input: "T?T?F:5:3"

 Output: "F"

 Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

 "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 -> "F"                                    -> "F"
 Hide Company Tags

 * Created by aoshen on 10/23/16.
 */
public class Solution {
    public String parseTernary(String expression) {
        if (null == expression || expression.length() == 0) return "";
        int idx = expression.length() - 1;
        String input = expression;

        while (input.length() > 1) {
            while (expression.charAt(idx) != '?') {
                idx --;
            }

            char trueOrFalse = input.charAt(idx - 1);
            char middle = trueOrFalse == 'T' ? input.charAt(idx + 1) : input.charAt(idx + 3);
            input = input.substring(0, idx - 1) + middle + input.substring(idx + 4);
            idx = idx - 2;
        }

        return input;
    }
}
