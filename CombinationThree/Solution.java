package CombinationThree;

import java.util.*;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

    Ensure that numbers within the set are sorted in ascending order.


    Example 1:

    Input: k = 3, n = 7

    Output:

    [[1,2,4]]

    Example 2:

    Input: k = 3, n = 9

    Output:

    [[1,2,6], [1,3,5], [2,3,4]]
 *
 * Created by aoshen on 4/3/16.
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();

        combination_helper(1, k, n, results, result);
        return results;
    }

    public void combination_helper(int cur, int k, int target, List<List<Integer>> results, List<Integer> result) {
        if (result.size() == k && target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = cur;i < 10;++ i) {
            result.add(i);
            combination_helper(i + 1, k, target - i, results, result);
            result.remove(result.size() - 1);
        }
    }
}
