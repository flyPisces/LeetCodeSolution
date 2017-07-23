package DiagonalTraverse;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in
 * diagonal order as shown in the below image.

 Example:
 Input:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Output:  [1,2,4,7,5,3,6,8,9]
 Explanation:

 Note:
 The total number of elements of the given matrix will not exceed 10,000.

 * Created by aoshen on 2/6/17.
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int m = matrix.length, n = matrix[0].length;
        int[] results = new int[m * n];

        int[][] dir = {{-1, 1},{1, -1}};
        int row = 0, col = 0, d = 0;

        for (int i = 0;i < m * n;++ i) {
            results[i] = matrix[row][col];

            row += dir[d][0];
            col += dir[d][1];

            if (row >= m) { row = m - 1; col += 2; d = 1 - d; }
            if (col >= n) { col = n - 1; row += 2; d = 1 - d; }
            if (row < 0) { row = 0; d = 1 - d; }
            if (col < 0) { col = 0; d = 1 - d; }

        }

        return results;
    }
}
