package RottingOranges;

import java.util.*;

/**
 * In a given grid, each cell can have one of three values:

 the value 0 representing an empty cell;
 the value 1 representing a fresh orange;
 the value 2 representing a rotten orange.
 Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

 Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 Input: [[2,1,1],[1,1,0],[0,1,1]]
 Output: 4
 Example 2:

 Input: [[2,1,1],[0,1,1],[1,0,1]]
 Output: -1
 Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 Example 3:

 Input: [[0,2]]
 Output: 0
 Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */

public class Solution {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> bfsQueue = new LinkedList<>();
        Map<Integer, Integer> depthMap = new HashMap<>();

        for (int i = 0;i < R;++ i) {
            for (int j = 0;j < C;++ j) {
                if (grid[i][j] == 2) {
                    bfsQueue.add(i * C + j);
                    depthMap.put(i * C + j, 0);
                }
            }
        }

        int ans = 0;

        while (!bfsQueue.isEmpty()) {
            int code = bfsQueue.poll();
            int r = code / C, c = code % C;

            for (int i = 0;i < 4;++ i) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int newCode = nr * C + nc;
                    bfsQueue.add(newCode);
                    depthMap.put(newCode, depthMap.get(code) + 1);
                    ans = depthMap.get(newCode);
                }
            }
        }


        for (int[] row : grid) {
            for (int v : row) {
                if (1 == v) return -1;
            }
        }

        return ans;
    }
}
