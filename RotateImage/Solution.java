package RotateImage;

/**
 * You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?
 *
 * Created by aoshen on 5/10/16.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length == matrix[0].length) {
            return;
        }

        for (int i = 0, j = matrix.length - 1;i < j;i ++, j --) {
            for (int k = i, d = j;k < j;k ++, d --) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[d][i];
                matrix[d][i] = matrix[j][d];
                matrix[j][d] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }
    }
}
