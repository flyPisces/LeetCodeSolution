package BombEnemy;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:
 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)

 * Created by aoshen on 7/23/16.
 */
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int ROWS = grid.length;
        int COLS = grid[0].length;

        int result = 0;
        int rowCache = 0;
        int[] colCache = new int[COLS];

        for (int i = 0;i < ROWS;++ i) {
            rowCache = 0;

            for (int j = 0;j < COLS;++ j) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCache = 0;
                    for (int k = j;k < COLS && grid[i][k] != 'W' ;++ k) {
                        if (grid[i][k] == 'E') {
                            rowCache++;
                        }
                    }
                }

                if (i == 0 || grid[i - 1][j] == 'W') {
                    colCache[j] = 0;
                    for (int k = i;k < ROWS && grid[k][j] != 'W';++ k) {
                        if (grid[k][j] == 'E') {
                            colCache[j]++;
                        }
                    }
                }

                if (grid[i][j] == '0') {
                    result = Math.max(result, rowCache + colCache[j]);
                }
            }
        }

        return result;
    }
}
