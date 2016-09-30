package Permutations;

import java.util.*;

/**
 * Given a collection of distinct numbers, return all possible permutations.

    For example,
    [1,2,3] have the following permutations:
    [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 */

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        boolean[] flag = new boolean[nums.length];
        permute_helper(results, result, nums, flag);
        
        return results;
    }
    
    public void permute_helper(List<List<Integer>> results, List<Integer> result, int[] nums, boolean[] flag) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        
        for (int i = 0;i != nums.length;++ i) {
            if (!flag[i]) {
                flag[i] = true;
                result.add(nums[i]);
                permute_helper(results, result, nums, flag);
                flag[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
