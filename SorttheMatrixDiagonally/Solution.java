package SorttheMatrixDiagonally;

import java.util.*;

/**
 *     public int[][] diagonalSort(int[][] mat) {
 *
 *     }Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
 */

public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> mapping = new HashMap<>();

        for (int i = 0;i < mat.length;++ i) {
            for (int j = 0;j < mat[0].length;++ j) {
                mapping.putIfAbsent(i - j, new PriorityQueue<Integer>());
                mapping.get(i - j).offer(mat[i][j]);
            }
        }

        for (int i = 0;i < mat.length;++ i) {
            for (int j = 0;j < mat[0].length;++ j) {
                mat[i][j] = mapping.get(i - j).poll();
            }
        }

        return mat;
    }
}
