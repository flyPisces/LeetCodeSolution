package MaximalSquare;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.

 * Created by aoshen on 6/21/16.
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        int[][] dp = new int[rows][cols];

        for (int i = 0;i < rows;++ i) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }

        for (int i = 0;i < cols;++ i) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(dp[0][i], max);
        }

        for (int i = 1;i < rows;++ i) {
            for (int j = 1;j < cols;++ j) {
                int temp = matrix[i][j] - '0';
                if (temp > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                   // max = Math.max(Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1, max);
                } else {
                    dp[i][j] = 0;
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }
}
