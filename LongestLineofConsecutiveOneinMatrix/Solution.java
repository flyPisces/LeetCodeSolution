package LongestLineofConsecutiveOneinMatrix;

/**
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.

 Example:
 Input:
 [[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
 Output: 3

 * Created by aoshen on 4/24/17.
 */
public class Solution {
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        int m = M.length, n = M[0].length;
        int max = 0;

        int[][][] dp = new int[m][n][4];
        for (int i = 0;i < m;++ i) {
            for (int j = 0;j < n;++ j) {
                if (M[i][j] == 0) continue;
                for (int k = 0;k < 4;++ k) dp[i][j][k] = 1;

                if (j > 0 && M[i][j - 1] == 1) dp[i][j][0] += dp[i][j - 1][0];
                if (i > 0 && M[i - 1][j] == 1) dp[i][j][1] += dp[i - 1][j][1];
                if (i > 0 && j > 0 && M[i - 1][j - 1] == 1) dp[i][j][2] += dp[i - 1][j - 1][2];
                if (i > 0 && j < n - 1 && M[i -1][j + 1] == 1) dp[i][j][3] += dp[i - 1][j + 1][3];

                max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        }

        return max;
    }
}
