package GreatestSumDivisiblebyThree;

/**
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 * Example 2:
 *
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * Example 3:
 *
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for (int num : nums) {
            int[] newDp = dp.clone();

            for (int sum : dp) {
                int newSum = sum + num;
                int idx = newSum % 3;

                newDp[idx] = Math.max(newDp[idx], newSum);
            }

            dp = newDp;
        }

        return dp[0];
    }
}
