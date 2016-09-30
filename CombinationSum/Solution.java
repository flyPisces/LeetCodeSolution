package CombinationSum;

import java.util.*;
/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

    The same repeated number may be chosen from C unlimited number of times.

    Note:
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
    For example, given candidate set 2,3,6,7 and target 7,
    A solution set is:
    [7]
    [2, 2, 3]
 *
 * Created by aoshen on 4/3/16.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        combination_sum_helper(candidates, target, 0, result, results);
        return results;
    }

    public void combination_sum_helper(int[] candidates, int target, int start, List<Integer> result, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        if (start >= candidates.length) {
            return;
        }

        for (int i = start;i != candidates.length;++ i) {
            if (i != 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }

            if (candidates[i] <= target) {
                result.add(candidates[i]);
                combination_sum_helper(candidates, target - candidates[i], i, result, results);
                result.remove(result.size() - 1);
            }
        }
    }
}
