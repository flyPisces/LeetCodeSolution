package ContainsDuplicateIII;

import java.util.*;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that
 * the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 *
 * Created by aoshen on 6/17/16.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length < 2) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0;i < nums.length;++ i) {
            long val = nums[i];

            if (!set.subSet((long)val - t, (long)val + t + 1).isEmpty()) {
                return true;
            }

            if (i >= k) {
                set.remove((long)nums[i - k]);
            }

            set.add(val);
        }

        return false;
    }
}
