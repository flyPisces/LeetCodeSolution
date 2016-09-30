package GuessNumberHigherorLowerTwo;

/**
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

 * Created by aoshen on 7/28/16.
 */
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return solve(dp, 1, n);
    }

    public int solve(int[][] dp, int left, int right) {
        if (left >= right) return 0;
        if (dp[left][right] != 0) return dp[left][right];
        dp[left][right] = Integer.MAX_VALUE;

        for (int i = left;i <= right;++ i) {
            dp[left][right] = Math.min(dp[left][right], i + Math.max(solve(dp, left, i - 1), solve(dp, i + 1, right)));
        }

        return dp[left][right];
    }
}
