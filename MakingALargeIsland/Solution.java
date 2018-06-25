package MakingALargeIsland;

import java.util.*;

/**
 * In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

 After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

 Example 1:

 Input: [[1, 0], [0, 1]]
 Output: 3
 Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 Example 2:

 Input: [[1, 1], [1, 0]]
 Output: 4
 Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 1.
 Example 3:

 Input: [[1, 1], [1, 1]]
 Output: 4
 Explanation: Can't change any 0 to 1, only one island with area = 1.
 */
public class Solution {
    public int largestIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int index = 2;
        Map<Integer, Integer> mapping = new HashMap<>();

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLS;++ j) {
                if (grid[i][j] == 1) {
                    mapping.put(index, dfs(grid, i, j, index));
                    index ++;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0;i < mapping.size();++ i) {
            maxArea = Math.max(maxArea, mapping.get(i + 2));
        }

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLS;++ j) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(getIndex(i + 1, j, grid));
                    set.add(getIndex(i - 1, j, grid));
                    set.add(getIndex(i, j - 1, grid));
                    set.add(getIndex(i, j + 1, grid));

                    int area = 1;
                    for (Integer idx : set) {
                        area += mapping.getOrDefault(idx, 0);
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int getIndex(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;

        return grid[row][col];
    }

    private int dfs(int[][] grid, int row, int col, int index) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
                grid[row][col] != 1) {
            return 0;
        }

        grid[row][col] = index;

        return 1 + dfs(grid, row + 1, col, index) +
                dfs(grid, row - 1, col, index) +
                dfs(grid, row, col + 1, index) +
                dfs(grid, row, col - 1, index);
    }
}
