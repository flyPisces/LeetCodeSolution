package Largest1BorderedSquare;

/**
 * Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.



 Example 1:

 Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
 Output: 9
 Example 2:

 Input: grid = [[1,1,0,0]]
 Output: 1
 */
public class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int[][] left = new int[rows][cols], top = new int[rows][cols];

        for (int i = 0;i < rows;++ i) {
            for (int j = 0;j < cols;++ j) {
                if (grid[i][j] == 1) {
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                    top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
                }
            }
        }

        for (int l = Math.min(rows, cols);l > 0;-- l) {
            for (int i = 0;i < rows - l + 1;++ i) {
                for (int j = 0;j < cols - l + 1;++ j) {
                    if (left[i][j + l - 1] >= l &&
                            left[i + l  -1][j + l - 1] >= l &&
                            top[i + l - 1][j] >= l &&
                            top[i + l - 1][j + l - 1] >= l) {
                        return l * l;
                    }
                }
            }
        }

        return 0;
    }
}
