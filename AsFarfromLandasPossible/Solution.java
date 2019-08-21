package AsFarfromLandasPossible;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.

 The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 If no land or water exists in the grid, return -1.

 */
public class Solution {

    int[][] directions = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1,0}};

    public int maxDistance(int[][] grid) {
        int levels = -1;

        if (null == grid || grid.length == 0 || grid[0].length == 0) return -1;

        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLS;++ j) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;++ i) {
                int[] top = queue.poll();

                for (int[] dir : directions) {
                    int newX = top[0] + dir[0], newY = top[1] + dir[1];

                    if (newX >= 0 && newX < ROWS && newY >= 0 && newY < COLS &&
                            visited[newX][newY] == false && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }

            levels ++;
        }

        return levels <= 0 ? -1 : levels;
    }
}
