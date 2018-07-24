package ScoreAfterFlippingMatrix;

/**
 * We have a two dimensional matrix A where each value is 0 or 1.

 A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

 After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

 Return the highest possible score.

 Example 1:

 Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 Output: 39
 Explanation:
 Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 */
public class Solution {
    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;

        for (int[] arr : A) {
            if (arr[0] == 0) {
                toggleRows(arr);
            }
        }

        int ans = 0;
        for (int j = 0;j < C;++ j) {
            int zero = 0;

            for (int i = 0;i < R;++ i) {
                if (A[i][j] == 0) {
                    zero ++;
                }
            }

            ans += Math.max(zero, R - zero) * (1 << (C - 1 - j));
        }

        return ans;
    }

    private void toggleRows(int[] arr) {
        for (int i = 0;i < arr.length;++ i) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }
}
