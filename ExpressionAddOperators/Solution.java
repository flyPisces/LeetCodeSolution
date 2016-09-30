package ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

    Examples:
    "123", 6 -> ["1+2+3", "1*2*3"]
    "232", 8 -> ["2*3+2", "2+3*2"]
    "105", 5 -> ["1*0+5","10-5"]
    "00", 0 -> ["0+0", "0-0", "0*0"]
    "3456237490", 9191 -> []

 * Created by aoshen on 6/4/16.
 */
public class Solution {
    List<String> results = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        helper(num, target, "", 0 , 0);
        return results;
    }

    public void helper(String num, int target, String tmp, long currRes, long prevNum) {
        if (num.isEmpty() && target == currRes) {
            results.add(new String(tmp));
            return;
        }

        for (int i = 1;i <= num.length();++ i) {
            String currStr = num.substring(0, i);
            long currNum = Long.parseLong(currStr);

            if (currStr.length() > 1 && currStr.charAt(0) == '0') {
                return;
            }
            String next = num.substring(i);
            if (!tmp.isEmpty()) {
                // +
                helper(next, target, tmp + "+" + currStr, currRes + currNum, currNum);
                // -
                helper(next, target, tmp + "-" + currStr, currRes - currNum, -currNum);
                // *
                helper(next, target, tmp + "*" + currStr, currRes - prevNum + prevNum * currNum, prevNum * currNum);
            } else {
                helper(next, target, currStr, currNum, currNum);
            }
        }
    }
}
