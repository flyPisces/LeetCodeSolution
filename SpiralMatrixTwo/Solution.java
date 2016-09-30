package SpiralMatrixTwo;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

    For example,
    Given n = 3,

    You should return the following matrix:
    [
    [ 1, 2, 3 ],
    [ 8, 9, 4 ],
    [ 7, 6, 5 ]
    ]
 *
 * Created by aoshen on 5/7/16.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int start = 0;

        int i = 0;
        int j = 0;

        while (i <= n - 1 - i && j <= n - 1 - j) {
            for (int k = j;k <= n - 1 - j;++ k) {
                result[i][k] = start ++;
            }

            for (int k = i + 1;k < n - 1 - i;++ k) {
                result[k][n - 1 - j] = start ++;
            }

            for (int k = n - 1 - j;k >= j;-- k) {
                result[n - 1 - i][k] = start ++;
            }

            for (int k = n - 2 - i;k > i;-- k) {
                result[k][j] = start ++;
            }

            ++ i;
            ++ j;
        }

        return result;
    }
}
