package NumberofDistinctIslands;

import java.util.*;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

 Example 1:
 11000
 11000
 00011
 00011
 Given the above grid map, return 1.
 Example 2:
 11011
 10000
 00001
 11011
 Given the above grid map, return 3.

 Notice that:
 11
 1
 and
 1
 11
 are considered different island shapes, because we do not consider reflection / rotation.
 Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Solution {
    int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<List<List<Integer>>> set = new HashSet<>();

        for (int i = 0;i < m;++ i) {
            for (int j = 0;j < n;++ j) {
                if (grid[i][j] > 0) {
                    List<List<Integer>> list = new ArrayList<>();
                    dfs(i, j, i, j, m, n, list, grid);
                    set.add(list);
                }
            }
        }

        return set.size();
    }

    private void dfs(int x0, int y0, int x, int y, int m, int n, List<List<Integer>> list, int[][] grid) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] <= 0) return;

        list.add(Arrays.asList(x - x0, y - y0));
        grid[x][y] *= -1;

        for (int[] dir : dirs) {
            dfs(x0, y0, x + dir[0], y + dir[1], m, n, list, grid);
        }
    }
}
