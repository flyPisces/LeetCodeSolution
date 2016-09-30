package LongestConsecutiveSequence;

import java.util.*;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.

 * Created by aoshen on 5/7/16.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0;i != nums.length;++ i) {
            if (set.contains(nums[i])) {
                int count = 1;
                set.remove(nums[i]);

                int low = nums[i] - 1;
                while (set.contains(low)) {
                    count ++;
                    set.remove(low);
                    low --;
                }

                int high = nums[i] + 1;
                while (set.contains(high)) {
                    count ++;
                    set.remove(high);
                    high ++;
                }

                max = Math.max(count, max);
            }
        }

        return max;
    }
}
