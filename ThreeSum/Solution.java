package ThreeSum;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:
    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.
    
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 *
 */

public class Solution {
    
    public void twoSum(int[] nums, int index, List<List<Integer>> results) {
        int start = index + 1;
        int end = nums.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        
        while (start < end) {
            if (nums[start] + nums[end] + nums[index] == 0) {
                result.add(nums[index]);
                result.add(nums[start]);
                result.add(nums[end]);
                
                results.add(new ArrayList<Integer>(result));
                result.clear();
                
                do {
                    start ++;
                } while (nums[start] == nums[start - 1] && start < end);
                
                do {
                    end --;
                } while (nums[end] == nums[end + 1] && start < end);
                
            } else if (nums[start] + nums[end] + nums[index] > 0) {
                end --;
            } else {
                start ++;
            }
        }
    }
    
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>(); 
        
        if (nums == null || nums.length < 3) {
            return results;
        }
             
        Arrays.sort(nums);
        
        for (int i = 0;i != nums.length - 2;++ i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            twoSum(nums, i, results);
        }
        
        return results;
    }
}
