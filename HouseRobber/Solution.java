package HouseRobber;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 * Created by aoshen on 5/21/16.
 */
public class Solution {
    public int rob(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2;i <= nums.length;++ i) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }

        return dp[nums.length];
    }
}
