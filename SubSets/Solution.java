package SubSets;

import java.util.*;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If nums = [1,2,3], a solution is:

    [
    [3],
    [1],
    [2],
    [1,2,3],
    [1,3],
    [2,3],
    [1,2],
    []
    ]
 *
 * Created by aoshen on 4/7/16.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();

        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        subset_helper(0, nums, results, result);

        return results;
    }

    public void subset_helper(int cur, int[] nums, List<List<Integer>> results, List<Integer> result) {
        if (cur == nums.length) {
            results.add(new ArrayList<Integer>(result));
            return;
        }

        result.add(nums[cur]);
        subset_helper(cur + 1, nums, results, result);
        result.remove(result.size() - 1);
        subset_helper(cur + 1, nums, results, result);
    }
}
