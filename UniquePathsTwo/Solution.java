package UniquePathsTwo;

/**
 * Follow up for "Unique Paths":

    Now consider if some obstacles are added to the grids. How many unique paths would there be?

    An obstacle and empty space is marked as 1 and 0 respectively in the grid.

    For example,
    There is one obstacle in the middle of a 3x3 grid as illustrated below.

    [
    [0,0,0],
    [0,1,0],
    [0,0,0]
    ]
    The total number of unique paths is 2.
 *
 * Created by aoshen on 4/14/16.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int rowNum = obstacleGrid.length;
        if (rowNum == 0) {
            return 0;
        }
        int colNum = obstacleGrid[0].length;
        if (colNum == 0) {
            return 0;
        }

        int[][] paths = new int[rowNum][colNum];

        for (int i = 0;i < rowNum;++ i) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                paths[i][0] = 1;
            }
        }

        for (int j = 0;j < colNum;++ j) {
            if (obstacleGrid[0][j] == 1) {
                break;
            } else {
                paths[0][j] = 1;
            }
        }

        for (int i = 1;i < rowNum;++ i) {
            for (int j = 1;j < colNum;++ j) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[rowNum - 1][colNum - 1];
    }
}
