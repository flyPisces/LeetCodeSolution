package TrappingRainWaterTwo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
 * compute the volume of water it is able to trap after raining.

 Note:
 Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

 Example:

 Given the following 3x6 height map:
 [
 [1,4,3,1,3,2],
 [3,2,1,3,2,4],
 [2,3,3,2,3,1]
 ]

 Return 4.

 * Created by aoshen on 9/25/16.
 */
public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(1, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.height - o2.height;
            }
        });

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0;i < m;++ i) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int i = 0;i < n;++ i) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        int result = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int i = 0;i < 4;++ i) {
                int nx = cell.row + dirs[i][0];
                int ny = cell.col + dirs[i][1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    result += Math.max(0, cell.height - heightMap[nx][ny]);
                    pq.offer(new Cell(nx, ny, Math.max(heightMap[nx][ny], cell.height)));
                }
            }
        }

        return result;
    }

    public class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
