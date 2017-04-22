package RemoveBoxes;

/**
 * Given several boxes with different colors represented by different positive numbers.
 You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
 Find the maximum points you can get.

 Example 1:
 Input:

 [1, 3, 2, 2, 2, 3, 4, 3, 1]
 Output:
 23
 Explanation:
 [1, 3, 2, 2, 2, 3, 4, 3, 1]
 ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 ----> [1, 3, 3, 3, 1] (1*1=1 points)
 ----> [1, 1] (3*3=9 points)
 ----> [] (2*2=4 points)
 Note: The number of boxes n would not exceed 100.

 * Created by aoshen on 4/16/17.
 */
public class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        int size = boxes.length;
        int[][][] dp = new int[size][size][size];

        return helper(dp, boxes, 0, size - 1, 1);
    }

    private int helper(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return k * k;
        } else  if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        } else {
            int temp = helper(dp, boxes, i + 1, j, 1) + k * k;

            for (int m = i + 1;m <= j;++ m) {
                if (boxes[m] == boxes[i]) {
                    temp = Math.max(temp, helper(dp, boxes, i + 1, m - 1, 1) + helper(dp, boxes, m, j, k + 1));
                }
            }

            dp[i][j][j] = temp;
            return temp;
        }
    }
}
