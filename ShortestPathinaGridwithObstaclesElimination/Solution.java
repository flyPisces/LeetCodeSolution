package ShortestPathinaGridwithObstaclesElimination;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *
 *
 * Example 2:
 *
 * Input:
 * grid =
 * [[0,1,1],
 *  [1,1,1],
 *  [1,0,0]],
 * k = 1
 * Output: -1
 * Explanation:
 * We need to eliminate at least two obstacles to find such a walk.
 */
public class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int shortestPath(int[][] grid, int k) {
        int M = grid.length, N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[M][N][k + 1];
        visited[0][0][0] = true;
        queue.offer(new int[] {0 , 0, 0});
        int result = 0;

        while (!queue.isEmpty()) {
            int SIZE = queue.size();

            for (int i = 0;i < SIZE;++ i) {
                int[] top = queue.poll();
                int x = top[0], y = top[1], currK = top[2];

                if (x == M - 1 && y == N - 1) {
                    return result;
                }

                for (int[] dir : dirs) {
                    int newX = x + dir[0], newY = y + dir[1], newK = currK;

                    if (newX < 0 || newX >= M || newY < 0 || newY >= N) continue;
                    if (grid[newX][newY] == 1) {
                        newK = currK + 1;
                    }
                    if (newK <= k && !visited[newX][newY][newK]) {
                        visited[newX][newY][newK] = true;
                        queue.offer(new int[] {newX, newY, newK});
                    }
                }
            }

            result ++;
        }

        return -1;
    }
}
