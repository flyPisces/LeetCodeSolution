package SwiminRisingWater;

import java.util.*;

/**
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

 Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

 You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?

 Example 1:

 Input: [[0,2],[1,3]]
 Output: 3
 Explanation:
 At time 0, you are in grid location (0, 0).
 You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.

 You cannot reach point (1, 1) until time 3.
 When the depth of water is 3, we can swim anywhere inside the grid.
 Example 2:

 Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
 Output: 16
 Explanation:
 0  1  2  3  4
 24 23 22 21  5
 12 13 14 15 16
 11 17 18 19 20
 10  9  8  7  6

 The final route is marked in bold.
 We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
 */
public class Solution {
    public int swimInWater(int[][] grid) {
        int ans = 0, N = grid.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((k1, k2) -> grid[k1 / N][k1 % N] -
                grid[k2 / N][k2 % N]);
        pq.add(0);

        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};


        while (!pq.isEmpty()) {
            int top = pq.poll();

            int currRow = top / N, currCol = top % N;
            ans = Math.max(ans, grid[currRow][currCol]);

            if (currRow == N - 1 && currCol == N - 1) return ans;

            for (int i = 0;i < 4;++ i) {
                int nextRow = currRow + dr[i], nextCol = currCol + dc[i],
                    nextIdx = nextRow * N + nextCol;

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N
                        && !seen.contains(nextIdx)) {
                    pq.add(nextIdx);
                    seen.add(nextIdx);
                }
            }
        }
        return ans;
    }
}
