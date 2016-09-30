package RemoveInvalidParentheses;

import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

    Note: The input string may contain letters other than the parentheses ( and ).

    Examples:
    "()())()" -> ["()()()", "(())()"]
    "(a)())()" -> ["(a)()()", "(a())()"]
    ")(" -> [""]

 * Created by aoshen on 6/4/16.
 */
public class Solution {

    List<String> result = new ArrayList<>();
    int max = 0;

    public List<String> removeInvalidParentheses(String s) {
        if (s != null && !s.isEmpty()) {
            dfs(s, "", 0, 0);
        }

        if (result.size() == 0) {
            result.add("");
        }

        return result;
    }

    public void dfs(String str, String res, int left, int maxLeft) {
        if (str.isEmpty()) {
            if (!res.isEmpty() && left == 0) {
                if (maxLeft > max) {
                    max = maxLeft;
                }

                if (max == maxLeft && !result.contains(res)) {
                    result.add(res);
                }
            }

            return;
        }

        if (str.charAt(0) == '(') {
            dfs(str.substring(1), res.concat("("), left + 1, maxLeft + 1);
            dfs(str.substring(1), res, left, maxLeft);
        } else if (str.charAt(0) == ')') {
            if (left > 0) {
                dfs(str.substring(1), res.concat(")"), left - 1, maxLeft);
            }
            dfs(str.substring(1), res, left, maxLeft);
        } else {
            dfs(str.substring(1), res.concat(String.valueOf(str.charAt(0))), left, maxLeft);
        }
    }
}
