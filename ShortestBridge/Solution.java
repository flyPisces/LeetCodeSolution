package ShortestBridge;

import java.util.*;

/**
 * In a given 2D binary array A, there are two islands.
 * (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

 Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

 Return the smallest number of 0s that must be flipped.
 (It is guaranteed that the answer is at least 1.)


 Example 1:

 Input: [[0,1],[1,0]]
 Output: 1
 Example 2:

 Input: [[0,1,0],[0,0,0],[0,0,1]]
 Output: 2
 Example 3:

 Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 Output: 1
 */
public class Solution {
    public int shortestBridge(int[][] A) {
        int ROWS = A.length, COLS = A[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;

        for (int i = 0;i < ROWS;++ i) {
            if (found) break;

            for (int j = 0;j < COLS;++ j) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, q, dirs, visited);
                    found = true;
                    break;
                }
            }
        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = size - 1;i >= 0;-- i) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int x0 = curr[0] + dir[0];
                    int y0 = curr[1] + dir[1];
                    if (x0 >= 0 && y0 >= 0 && x0 < ROWS && y0 < COLS && !visited[x0][y0]) {
                        if (A[x0][y0] == 1) {
                            return step;
                        }
                        q.offer(new int[]{x0, y0});
                        visited[x0][y0] = true;
                    }
                }
            }
            step ++;
        }

        return -1;
    }

    private void dfs(int[][] A, int x0, int y0, Queue<int[]> q, int[][] dirs, boolean[][] visited) {
        if (x0 < 0 || x0 >= A.length || y0 < 0 || y0 >= A[0].length
                || visited[x0][y0] || A[x0][y0] == 0) {
            return;
        }

        visited[x0][y0] = true;
        q.offer(new int[]{x0, y0});

        for (int[] dir : dirs) {
            dfs(A, x0 + dir[0], y0 + dir[1], q, dirs, visited);
        }
    }
}
