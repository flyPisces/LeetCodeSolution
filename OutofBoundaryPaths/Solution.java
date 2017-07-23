package OutofBoundaryPaths;

/**
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball,
 * you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right).
 *
 * However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 109 + 7.
 *
 * Input:m = 2, n = 2, N = 2, i = 0, j = 0
 Output: 6

 Input:m = 1, n = 3, N = 3, i = 0, j = 1
 Output: 12
 * Created by aoshen on 5/13/17.
 */
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        final int MOD = 1000000007;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0;step < N;++ step) {
            int[][] temp = new int[m][n];

            for (int r = 0;r < m;++ r) {
                for (int c = 0;c < n;++ c) {
                    for (int[] dir : dirs) {
                        int nr = dir[0] + r;
                        int nc = dir[1] + c;

                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }

            count = temp;
        }

        return result;
    }
}
