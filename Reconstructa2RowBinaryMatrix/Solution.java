package Reconstructa2RowBinaryMatrix;

import java.util.*;

/**
 * Given the following details of a matrix with n columns and 2 rows :
 *
 * The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
 * The sum of elements of the 0-th(upper) row is given as upper.
 * The sum of elements of the 1-st(lower) row is given as lower.
 * The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 *
 * Return it as a 2-D integer array.
 *
 * If there are more than one valid solution, any of them will be accepted.
 *
 * If no valid solution exists, return an empty 2-D array.
 *
 *
 *
 * Example 1:
 *
 * Input: upper = 2, lower = 1, colsum = [1,1,1]
 * Output: [[1,1,0],[0,0,1]]
 * Explanation: [[1,0,1],[0,1,0]], and [[0,1,1],[1,0,0]] are also correct answers.
 * Example 2:
 *
 * Input: upper = 2, lower = 3, colsum = [2,2,1,1]
 * Output: []
 * Example 3:
 *
 * Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 */
public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        boolean[][] flags = new boolean[2][colsum.length];

        for (int i = 0;i < colsum.length;++ i) {
            flags[0][i] = colsum[i] == 2 || (colsum[i] == 1 && lower < upper);
            flags[1][i] = colsum[i] == 2 || (colsum[i] == 1 && !flags[0][i]);
            upper -= flags[0][i] ? 1 : 0;
            lower -= flags[1][i] ? 1 : 0;
        }

        return upper == 0 && lower == 0 ? new ArrayList(Arrays.asList(flags[0], flags[1])) : new ArrayList();
    }
}
