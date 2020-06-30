package CherryPickupII;

import java.util.Map;

/**
 * Given a rows x cols matrix grid representing a field of cherries. Each cell in grid represents the number of cherries that you can collect.
 *
 * You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0) , and Robot #2 is located at the top-right corner (0, cols-1) of the grid.
 *
 * Return the maximum number of cherries collection using both robots  by following the rules below:
 *
 * From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
 * When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
 * When both robots stay on the same cell, only one of them takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in the grid.
 */
public class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];

        return dfs(grid, dp, m, n, 0, 0, n - 1);
    }

    private int dfs(int[][] grid, Integer[][][] dp, int m, int n, int r, int c1, int c2) {
        if (r == m) return 0;
        if (dp[r][c1][c2] != null) {
            return dp[r][c1][c2];
        }

        int max = 0;
        for (int l1 = -1;l1 <= 1;++ l1) {
            for (int l2 = -1;l2 <= 1;++ l2) {
                int nc1 = c1 + l1, nc2 = c2 + l2;

                if (nc1 < 0 || nc1 >= n || nc2 < 0 || nc2 >= n) continue;

                max = Math.max(max, dfs(grid, dp, m, n, r + 1, nc1, nc2));
            }
        }

        int result = max + (c1 == c2 ? grid[r][c1] : (grid[r][c1] + grid[r][c2]));
        dp[r][c1][c2] = result;

        return dp[r][c1][c2];
    }
}
