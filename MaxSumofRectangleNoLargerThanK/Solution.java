package MaxSumofRectangleNoLargerThanK;

import java.util.TreeSet;

/**
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

 Example:
 Given matrix = [
 [1,  0, 1],
 [0, -2, 3]
 ]
 k = 2
 The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).

 Note:
 The rectangle inside the matrix must have an area > 0.
 What if the number of rows is much larger than the number of columns?

 * Created by aoshen on 7/30/16.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;

        int[][] dp = new int[rows][cols];

        for (int i = 0;i < rows;++ i) {
            for (int j = 0;j < cols;++ j) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }
            }
        }

        for (int i = 0;i < rows;++ i) {
            for (int j = i;j < rows;++ j) {
                TreeSet<Integer> ts = new TreeSet<>();
                int sum = 0;
                for (int m = 0;m < cols;++ m) {
                    sum += i == 0 ? dp[j][m] : dp[j][m] - dp[i - 1][m];

                    if (sum == k) {
                        return k;
                    }

                    if (sum < k) max = Math.max(max, sum);
                    Integer other = ts.ceiling(sum - k);
                    ts.add(sum);
                    if (other == null) continue;
                    max = Math.max(max, sum - other);
                }
            }
        }

        return max;
    }
}
