package CountSquareSubmatriceswithAllOnes;

/**
 *Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 */
public class Solution {
    public int countSquares(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int[][] dp = new int[ROWS][COLS];

        for (int i = 0;i < ROWS;++ i) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 0;i < COLS;++ i) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1;i < ROWS;++ i) {
            for (int j = 1;j < COLS;++ j) {
                if (matrix[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }

        int result = 0;

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLS;++ j) {
                result += dp[i][j];
            }
        }

        return result;
    }
}
