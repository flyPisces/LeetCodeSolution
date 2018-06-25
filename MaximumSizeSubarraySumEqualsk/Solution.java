package MaximumSizeSubarraySumEqualsk;

import java.util.*;

/**
 * Given an array nums and a target value k,
 * find the maximum length of a subarray that sums to k.
 * If there isn't one, return 0 instead.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Follow Up:
 Can you do it in O(n) time?

 * Created by aoshen on 7/3/16.
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> helper = new HashMap<>();
        helper.put(0, -1);

        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0;i < nums.length;++ i) {
            sum += nums[i];

            if (!helper.containsKey(sum)) {
                helper.put(sum, i);
            }

            if (helper.containsKey(sum - k)) {
                int startIndex = helper.get(sum - k);
                maxLen = Math.max(maxLen, i - startIndex);
            }
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;

    }
}
