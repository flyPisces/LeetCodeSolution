package LargestDivisibleSubset;

import java.util.*;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 nums: [1,2,3]

 Result: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 nums: [1,2,4,8]

 Result: [1,2,4,8]

 * Created by aoshen on 7/24/16.
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);
        int[] indexes = new int[nums.length];
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(indexes, -1);

        int max = 0;
        int max_index = -1;
        for (int i = 0;i < nums.length;++ i) {
            for (int j = i- 1;j >= 0;-- j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    indexes[i] = j;
                }
            }

            if (dp[i] > max) {
                max = dp[i];
                max_index = i;
            }
        }

        for (int i = max_index;i != -1;i = indexes[i]) {
            results.add(nums[i]);
        }

        return results;
    }
}
