package GenerateParentheses;

import java.util.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"
 * @author alshen
 *
 */


public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        
        if (n == 0) {
            return res;
        }
        
        recursiveBuild(n, n, res, "");
        
        return res;
    }
    
    public void recursiveBuild(int left, int right, List<String> res, String temp) {
        if (left > right) {
            return;
        }
        
        if (left < 0 || right < 0) {
            return;
        }
        
        if (left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        
        recursiveBuild(left - 1, right, res, temp + "(");
        recursiveBuild(left, right - 1, res, temp + ")");
    }
}
