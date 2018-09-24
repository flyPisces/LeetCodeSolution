package SpiralMatrixIII;

import java.util.ArrayList;
import java.util.List;

/**
 * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

 Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.

 Now, we walk in a clockwise spiral shape to visit every position in this grid.

 Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.)

 Eventually, we reach all R * C spaces of the grid.

 Return a list of coordinates representing the positions of the grid in the order they were visited.
 */
public class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dirs = new int[][] {{0, 1},{1, 0}, {0, -1},{-1, 0}};
        List<int[]> results = new ArrayList<>();
        int len = 0, d = 0;
        results.add(new int[] {r0, c0});

        while (results.size() < R * C) {
            if (d == 0 || d == 2) len ++;

            for (int i = 0;i < len;++ i) {
                r0 = r0 + dirs[d][0];
                c0 = c0 + dirs[d][1];

                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    results.add(new int[]{r0, c0});
                }
            }
            d = (d + 1) % 4;
        }

        return results.toArray(new int[R * C][2]);
    }
}
