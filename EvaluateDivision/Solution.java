package EvaluateDivision;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

 * Created by aoshen on 9/12/16.
 */
public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        double[] results = new double[query.length];

        Set<String> words = new HashSet<>();
        for (String[] equation : equations) {
            words.add(equation[0]);
            words.add((equation[1]));
        }

        int index = 0;
        for (String[] keys : query) {
            if (!words.contains(keys[0]) && !words.contains(keys[1])) results[index ++] = -1.0d;
            else {
                Stack<Integer> stack = new Stack<>();
                results[index ++] = helper(equations, values, keys, stack);
            }
        }
        return results;
    }

    public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {
        for (int i = 0;i < equations.length;++ i) {
            if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1])) return values[i];
            if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0])) return 1 / values[i];
        }

        for (int i = 0;i < equations.length;++ i) {
            if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
                stack.push(i);
                double temp = values[i] * helper(equations, values, new String[] {equations[i][1], keys[1]}, stack);
                if (temp > 0) return temp;
                else stack.pop();
            } else if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
                stack.push(i);
                double temp = helper(equations, values, new String[] {equations[i][0], keys[1]}, stack) / values[i];
                if (temp > 0) return temp;
                else stack.pop();
            }
        }

        return -1.0d;
    }
}
