package BurstBalloons;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

    Find the maximum coins you can collect by bursting the balloons wisely.

    Note:
    (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

    Example:

    Given [3, 1, 5, 8]

    Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
    coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 * Created by aoshen on 5/30/16.
 */
public class Solution {

    private int dp_helper(int i, int j, int[] arr, int[][] dp) {
        if (dp[i][j] > 0) return dp[i][j];

        for (int x = i;x <= j;++ x) {
            dp[i][j] = Math.max(dp[i][j], dp_helper(i, x - 1, arr, dp) + arr[i - 1] * arr[x] * arr[j + 1] +
            dp_helper(x + 1, j, arr, dp));
        }

        return dp[i][j];
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] arr = new int[len + 2];
        arr[0] = arr[len + 1] = 1;
        for (int i = 1;i <= len;++ i) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[len + 2][len + 2];
        return dp_helper(1, len, arr, dp);
    }
}
