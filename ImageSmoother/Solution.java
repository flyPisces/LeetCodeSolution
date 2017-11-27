package ImageSmoother;

/**
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down)
 * of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

 Example 1:
 Input:
 [[1,1,1],
 [1,0,1],
 [1,1,1]]
 Output:
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 Explanation:
 For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 For the point (1,1): floor(8/9) = floor(0.88888889) = 0

 * Created by aoshen on 8/23/17.
 */
public class Solution {
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length, cols = M[0].length;

        int[][] ans = new int[rows][cols];

        for (int i = 0;i < rows;++ i) {
            for (int j = 0;j < cols;++ j) {
                int sum = 0, count = 0;

                for (int m = -1;m <= 1;++ m) {
                    for (int n = -1;n <= 1;++ n) {
                        int row = i + m, col = j + n;

                        if (row >= 0 && row < rows && col >= 0 && col < cols) {
                            ++ count;
                            sum += M[row][col];
                        }
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}
