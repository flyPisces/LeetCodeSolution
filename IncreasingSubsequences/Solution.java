package IncreasingSubsequences;

import java.util.*;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

 Example:
 Input: [4, 6, 7, 7]
 Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 Note:
 The length of the given array will not exceed 15.
 The range of integer in the given array is [-100,100].
 The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.

 * Created by aoshen on 1/24/17.
 */
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        helper(results, new ArrayList<Integer>(), 0, nums);
        return results;
    }

    public void helper(List<List<Integer>> results, List<Integer> result, int id, int[] nums) {
        if (result.size() > 1) results.add(new ArrayList<>(result));
        Set<Integer> uniqSet = new HashSet<>();

        for (int i = id;i < nums.length;++ i) {
            if (id > 0 && nums[i] < nums[id - 1]) continue;
            if (uniqSet.contains(nums[i])) continue;
            uniqSet.add(nums[i]);
            result.add(nums[i]);
            helper(results, result, i + 1, nums);
            result.remove(result.size() - 1);
        }
    }
}
