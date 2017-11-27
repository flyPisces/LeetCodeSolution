package PartitiontoKEqualSumSubsets;

/**
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:
 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 Note:

 1 <= k <= len(nums) <= 16.
 0 < nums[i] < 10000.
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k <= 0) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        return dfs(nums, new boolean[nums.length], 0, k, 0, 0, sum / k);

    }

    private boolean dfs(int[] nums, boolean[] flags, int start_index, int k, int num_count, int curr_sum, int target) {
        if (1 == k) return true;
        if (curr_sum == target && num_count > 0) return dfs(nums, flags, 0, k - 1, 0, 0, target);
        for (int i = start_index;i < nums.length;++ i) {
            if (flags[i] == false) {
                flags[i] = true;
                if (dfs(nums, flags, i + 1, k, num_count + 1, curr_sum + nums[i], target)) {
                    return true;
                }
                flags[i] = false;
            }
        }
        return false;
    }
}
