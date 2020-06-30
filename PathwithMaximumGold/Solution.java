package PathwithMaximumGold;

import java.util.*;

/**
 *
 In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

 Return the maximum amount of gold you can collect under the conditions:

 Every time you are located in a cell you will collect all the gold in that cell.
 From your position you can walk one step to the left, right, up or down.
 You can't visit the same cell more than once.
 Never visit a cell with 0 gold.
 You can start and stop collecting gold from any position in the grid that has some gold.


 Example 1:

 Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 Output: 24
 Explanation:
 [[0,6,0],
 [5,8,7],
 [0,9,0]]
 Path to get the maximum gold, 9 -> 8 -> 7.
 Example 2:

 Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 Output: 28
 Explanation:
 [[1,0,7],
 [2,0,6],
 [3,4,5],
 [0,3,0],
 [9,0,20]]
 Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
 */
public class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int result = 0, M = grid.length, N = grid[0].length;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0;i < M;++ i) {
            for (int j = 0;j < N;++ j) {
                result = Math.max(result, dfs(grid, i, j, M, N, 0, visited));
            }
        }

        return result;
    }

    private int dfs(int[][] grid, int i, int j, int M, int N, int sum, Set<Integer> visited) {
        if (i < 0 || i >= M || j < 0 || j >= N || visited.contains(i * N + j) || grid[i][j] == 0) return sum;

        visited.add(i * N + j);
        int result = 0;

        sum += grid[i][j];
        for (int[] dir : dirs) {
            result = Math.max(result, dfs(grid, i + dir[0], j + dir[1], M, N, sum, visited));
        }

        visited.remove(i * N + j);
        return result;
    }
}
