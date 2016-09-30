package NumberOfIslands;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    11110
    11010
    11000
    00000
    Answer: 1

    Example 2:

    11000
    11000
    00100
    00011
    Answer: 3
 *
 * Created by aoshen on 4/6/16.
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int num = 0;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return num;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0;i != m;++ i) {
            for (int j = 0;j != n;++ j) {
                if (grid[i][j] == '1') {
                    num ++;
                    bfs(grid, m, n, i, j);
                }
            }
        }

        return num;
    }

    public void bfs(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            bfs(grid, m, n, i - 1, j);
            bfs(grid, m, n, i + 1, j);
            bfs(grid, m, n, i, j - 1);
            bfs(grid, m, n, i, j + 1);
        }
    }
}
