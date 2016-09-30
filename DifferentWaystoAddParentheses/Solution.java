package DifferentWaystoAddParentheses;

import java.util.*;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]


 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]

 * Created by aoshen on 8/5/16.
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0;i < input.length();++ i) {
            char ch = input.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> leftResults = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i + 1));

                for (int leftRes : leftResults) {
                    for (int rightRes : rightResults) {
                        switch (ch) {
                            case '+':
                                results.add(leftRes + rightRes);
                                break;
                            case  '-':
                                results.add(leftRes - rightRes);
                                break;
                            case '*':
                                results.add(leftRes * rightRes);
                                break;
                        }
                    }
                }
            }
        }

        if (results.size() == 0) {
            results.add(Integer.parseInt(input));
        }

        return results;
    }
}
