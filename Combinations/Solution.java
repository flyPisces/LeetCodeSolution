package Combinations;

import java.util.*;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    For example,
    If n = 4 and k = 2, a solution is:

    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
 *
 */

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        
        recursiveBuildCombination(result, temp, 1, k, n);
        
        return result;
    }
    
    public void recursiveBuildCombination(List<List<Integer>> result, List<Integer> temp, int index, int k, int n) {
        if (temp.size() == k) {
            List<Integer> candidate = new ArrayList<Integer>();
            candidate.addAll(temp);
            
            result.add(candidate);
            return;
        }
        
        if (index > n) {
            return;
        }
        
        temp.add(index);
        recursiveBuildCombination(result, temp, index + 1, k, n);
        temp.remove(temp.size() - 1);
        recursiveBuildCombination(result, temp, index + 1, k, n);
    }
}
