package SpiralMatrix;

import java.util.*;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 *
 * Created by aoshen on 5/7/16.
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int i = 0;
        int j = 0;

        while (i < row - 1 - i && j < column - 1 - j) {

            for (int k = j;k <= column - 1 - j;++ k) {
                result.add(matrix[i][k]);
            }

            for (int k= i + 1;k < row - i - 1;++ k) {
                result.add(matrix[k][column - 1 - j]);
            }

            for (int k = column - 1 - j;k >= j;-- k ) {
                result.add(matrix[row - 1 - i][k]);
            }
            
            for (int k = row - i - 2;k >= i + 1;-- k) {
                result.add(matrix[k][j]);
            }

            ++i;
            ++j;
        }

        if (i == row - 1 - i && j == column - 1 - j) {
            result.add(matrix[i][j]);
        } else if (i == row - 1 - i) {
            for (int k = j;k <= column - 1 - j;++ k) {
                result.add(matrix[i][k]);
            }
        } else if (j == column - 1 - j) {
            for (int k = i;k <= row - 1 - i;++ k) {
                result.add(matrix[k][j]);
            }
        }

        return result;
    }
}
