package ContainsDuplicate;

import java.util.*;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

 Hide Company Tags

 * Created by aoshen on 8/5/16.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> eleSet = new HashSet<>();

        for (int num : nums) {
            if (eleSet.contains(num)) return true;
            eleSet.add(num);
        }

        return false;
    }
}
