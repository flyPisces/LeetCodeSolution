package LargestPlusSign;

import java.util.*;

/**
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1, except those cells in the given list mines which are 0. What is the largest axis-aligned plus sign of 1s contained in the grid? Return the order of the plus sign. If there is none, return 0.

 An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below. Note that there could be 0s or 1s beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1s.
 */
public class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for (int[] arr : mines) {
            set.add(arr[0] * N + arr[1]);
        }

        int count = 0;

        for (int i = 0;i < N;++ i) {
            count = 0;

            for (int j = 0;j < N;++ j) {
                count = set.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = count;
            }

            count = 0;
            for (int j = N - 1;j >= 0;-- j) {
                count = set.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(count, dp[i][j]);
            }
        }

        for (int i = 0;i < N;++ i) {
            count = 0;
            for (int j = 0;j < N;++ j) {
                count = set.contains(j * N + i) ? 0 : count + 1;
                dp[j][i] = Math.min(count, dp[j][i]);
            }

            count = 0;
            for (int j = N - 1;j >= 0;-- j) {
                count = set.contains(j * N + i) ? 0 : count + 1;
                dp[j][i] = Math.min(count, dp[j][i]);
                ans = Math.max(dp[j][i], ans);
            }
        }

        return ans;
    }
}
