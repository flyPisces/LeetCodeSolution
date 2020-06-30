package Shift2DGrid;

import java.util.*;

/**
 * Given a 2D grid of size n * m and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 * Element at grid[i][j] becomes at grid[i][j + 1].
 * Element at grid[i][m - 1] becomes at grid[i + 1][0].
 * Element at grid[n - 1][m - 1] becomes at grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int M = grid.length, N = grid[0].length, start = M * N - k % (M * N);

        List<List<Integer>> results = new ArrayList<>();

        for (int i = start;i < M * N + start;++ i) {
            int j = i % (M * N), nr = j / N, nc = j % N;

            if ((i - start) % N == 0) {
                results.add(new ArrayList<>());
            }

            results.get(results.size() - 1).add(grid[nr][nc]);
        }

        return results;
    }
}
