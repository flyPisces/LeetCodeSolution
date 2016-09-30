package PaintFence;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.

 You have to paint all the posts such that no more than two adjacent fence posts have the same color.

 Return the total number of ways you can paint the fence.

 * Created by aoshen on 7/21/16.
 */
public class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[] {0, k, k * k, 0};

        if (n <= 2) {
            return dp[n];
        }

        for (int i = 3;i <= n;++ i) {
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }

        return dp[3];
    }
}
