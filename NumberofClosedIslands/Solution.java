package NumberofClosedIslands;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 *
 * Return the number of closed islands.
 */
public class Solution {
    int[][] dirs = new int[][] { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        for (int i = 0;i < grid.length;++ i) {
            for (int j = 0;j < grid[0].length;++ j) {
                if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
                    fill(grid, i, j);
                }
            }
        }

        int result = 0;

        for (int i = 0;i < grid.length;++ i) {
            for (int j = 0;j < grid[0].length;++ j) {
                if (grid[i][j] == 0) {
                    ++ result;
                    fill(grid, i, j);
                }
            }
        }

        return result;
    }

    private void fill(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) return;

        grid[x][y] = 1;

        for (int[] dir : dirs) {
            fill(grid, x + dir[0], y + dir[1]);
        }
    }
}
