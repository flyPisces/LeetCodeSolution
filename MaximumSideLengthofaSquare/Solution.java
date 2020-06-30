package MaximumSideLengthofaSquare;

/**
 * Given a m x n matrix mat and an integer threshold. Return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
 *
 *
 */
public class Solution {
    int M = 0, N = 0;

    public int maxSideLength(int[][] mat, int threshold) {
        M = mat.length;
        N = mat[0].length;

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1;i <= M;++ i) {
            for (int j = 1;j <= N;++ j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(M, N);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isAccepatable(dp, threshold, mid)) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean isAccepatable(int[][] dp, int threshold, int len) {
        for (int i = len;i <= M;++ i) {
            for (int j = len;j <= N;++ j) {
                if (dp[i][j] - dp[i - len][j] - dp[i][j - len] + dp[i - len][j - len] <= threshold) return true;
            }
        }

        return false;
    }
}
