package StoneGameII;

/**
 * Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.

 Alex and Lee take turns, with Alex starting first.  Initially, M = 1.

 On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

 The game continues until all the stones have been taken.

 Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.



 Example 1:

 Input: piles = [2,7,9,4,4]
 Output: 10
 Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 */
public class Solution {
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N][N];
        int[] sum = new int[N];

        sum[N - 1] = piles[N - 1];
        for (int i = N - 2;i >= 0;-- i) {
            sum[i] = sum[i + 1] + piles[i];
        }

        return dp(0, 1, sum, dp);
    }

    private int dp(int index, int M, int[] sum, int[][] dp) {
        if (index == sum.length) return 0;
        if (index + 2 * M >= sum.length) return sum[index];
        if (dp[index][M] > 0) return dp[index][M];

        int min = Integer.MAX_VALUE;
        for (int x = 1;x <= 2 * M;++ x) {
            min = Math.min(min, dp(index + x, Math.max(x, M), sum, dp));
        }

        dp[index][M] = sum[index] - min;

        return dp[index][M];
    }
}
