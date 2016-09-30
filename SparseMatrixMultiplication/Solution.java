package SparseMatrixMultiplication;

/**
 * Given two sparse matrices A and B, return the result of AB.

 You may assume that A's column number is equal to B's row number.

 Example:

 A = [
 [ 1, 0, 0],
 [-1, 0, 3]
 ]

 B = [
 [ 7, 0, 0 ],
 [ 0, 0, 0 ],
 [ 0, 0, 1 ]
 ]


 |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 | 0 0 1 |

 * Created by aoshen on 8/15/16.
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int Arows = A.length;
        int ACols = A[0].length;
        int BCols = B[0].length;

        int[][] C = new int[Arows][BCols];
        for (int i = 0;i < Arows;++ i) {
            for (int k = 0;k < ACols;++ k) {
                if (A[i][k] != 0) {
                    for (int j = 0;j < BCols;++ j) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }

        return C;
    }
}
