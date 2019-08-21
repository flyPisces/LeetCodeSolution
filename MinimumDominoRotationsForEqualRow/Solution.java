package MinimumDominoRotationsForEqualRow;

/***
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

 We may rotate the i-th domino, so that A[i] and B[i] swap values.

 Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

 If it cannot be done, return -1.

 Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 Output: 2
 Explanation:
 The first figure represents the dominoes as given by A and B: before we do any rotations.
 If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 */
public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int N = A.length;

        for (int i = 0, a = 0, b = 0;i < N && (A[0] == A[i] || A[0] == B[i]);++ i) {
            if (A[0] != A[i]) ++ a;
            if (A[0] != B[i]) ++ b;

            if (i == N - 1) return Math.min(a, b);
        }

        for (int i = 0, a = 0, b = 0;i < N && (B[0] == A[i] || B[0] == B[i]);++ i) {
            if (B[0] != A[i]) ++ a;
            if (B[0] != B[i]) ++ b;

            if (i == N - 1) return Math.min(a, b);
        }

        return -1;
    }
}
