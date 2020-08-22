package MatrixBlockSum;

import java.util.Map;

/**
 * Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * Example 2:
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 */
public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int ROWS = mat.length, COLS = mat[0].length;
        int[][] sums = new int[ROWS + 1][COLS + 1];

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLS;++ j) {
                sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + mat[i][j];
            }
        }

        int[][] results = new int[ROWS][COLS];

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLS;++ j) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(i + K + 1, ROWS), c2 = Math.min(j + K + 1, COLS);
                results[i][j] = sums[r1][c1] + sums[r2][c2] - sums[r1][c2] - sums[r2][c1];
            }
        }


        return results;
    }
}
