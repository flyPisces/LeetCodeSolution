package KnightProbabilityinChessboard;

import java.util.Arrays;

/**
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

 A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

 Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

 The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.

 Example:
 Input: 3, 2, 0, 0
 Output: 0.0625
 Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 From each of those positions, there are also two moves that will keep the knight on the board.
 The total probability the knight stays on the board is 0.0625.
 */
public class Solution {
    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];

        for (int i = 0;i < N;++ i) {
            Arrays.fill(dp[i], 1);
        }

        for (int i = 0;i < K;++ i) {
            double[][] temp = new double[N][N];
            for (int m = 0;m < N;++ m) {
                for (int n = 0;n < N;++ n) {
                    for (int[] move : moves) {
                        int row = move[0] + m, col = move[1] + n;

                        if (isValid(N, row, col)) {
                            temp[m][n] += dp[row][col];
                        }
                    }
                }
            }
            dp = temp;
        }

        return dp[r][c] / Math.pow(8, K);
    }

    private boolean isValid(int N, int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
