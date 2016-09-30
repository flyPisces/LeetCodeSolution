package PermutationTwo;

import java.util.*;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

    For example,
    [1,1,2] have the following unique permutations:
    [1,1,2], [1,2,1], and [2,1,1].
 * 
 *
 */

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        
        permute_helper(results, result, nums, visited);
        
        return results;
    }
    
    public void permute_helper(List<List<Integer>> results, List<Integer> result, int[] nums, boolean[] visited) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<Integer>(result));
            return;
        }
        
        for (int i = 0;i != nums.length;++ i) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            
            if (visited[i] == false)
            {
                visited[i] = true;
                result.add(nums[i]);
                permute_helper(results, result, nums, visited);
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
    
}
