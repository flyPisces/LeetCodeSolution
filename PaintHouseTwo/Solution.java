package PaintHouseTwo;

/**
 *
 There are a row of n houses, each house can be painted with one of the k colors.
 The cost of painting each house with a certain color is different.
 You have to paint all the houses such that no two adjacent houses have the same color.

 The cost of painting each house with a certain color is represented by a n x k cost matrix.
 For example, costs[0][0] is the cost of painting house 0 with color 0;
 costs[1][2] is the cost of painting house 1 with color 2, and so on...

 Find the minimum cost to paint all houses.

 * Created by aoshen on 6/25/16.
 */
public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int preIndex = -1;
        int preMin = 0;
        int preSecond = 0;

        int rows = costs.length;
        int cols = costs[0].length;

        for (int i = 0;i < rows;++ i) {
            int currMin = Integer.MAX_VALUE;
            int currSecond = Integer.MAX_VALUE;
            int currIndex = 0;

            for (int j = 0;j < cols;++ j) {
                if (j == preIndex) {
                    costs[i][j] = preSecond + costs[i][j];
                } else {
                    costs[i][j] = preMin + costs[i][j];
                }

                if (currMin > costs[i][j]) {
                    currSecond = currMin;
                    currMin = costs[i][j];
                    currIndex = j;
                } else if (currSecond > costs[i][j]) {
                    currSecond = costs[i][j];
                }
            }

            preIndex = currIndex;
            preMin = currMin;
            preSecond = currSecond;
        }

        for (int i = 0;i < cols;++ i) {
            result = Math.min(result, costs[rows - 1][i]);
        }

        return result;
    }
}
