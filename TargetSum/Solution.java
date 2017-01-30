package TargetSum;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.

 * Created by aoshen on 1/26/17.
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum < S || (sum + S) % 2 > 0 ? 0 : subSetSum(nums, (sum + S) >>> 1);
    }

    public int subSetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;

        for (int n : nums) {
            for (int i = s;i >= n;-- i) {
                dp[i] += dp[i - n];
            }
        }

        return dp[s];
    }
}
