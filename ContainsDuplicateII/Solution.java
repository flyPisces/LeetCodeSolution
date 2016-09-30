package ContainsDuplicateII;

import java.util.*;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * Created by aoshen on 6/16/16.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0;i < nums.length;++ i) {
            if (mapping.containsKey(nums[i])) {
                if (Math.abs(i - mapping.get(nums[i])) <= Math.abs(k)) {
                    return true;
                }
                mapping.put(nums[i],i);
            } else {
                mapping.put(nums[i],i);
            }
        }

        return false;
    }
}
