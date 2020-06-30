package LuckyNumbersinaMatrix;

import java.util.*;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 */
public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;

        int[] rowMins = new int[M], colMaz = new int[N];
        Arrays.fill(rowMins, Integer.MAX_VALUE);
        Arrays.fill(colMaz, Integer.MIN_VALUE);

        for (int i = 0;i < M;++ i) {
            for (int j = 0;j < N;++ j) {
                rowMins[i] = Math.min(rowMins[i], matrix[i][j]);
                colMaz[j] = Math.max(colMaz[j], matrix[i][j]);
            }
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0;i < M;++ i) {
            for (int j = 0;j < N;++ j) {
                if (rowMins[i] == colMaz[j]) results.add(rowMins[i]);
            }
        }

        return results;
    }
}
