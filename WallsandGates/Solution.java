package WallsandGates;

import java.util.*;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.
 0 - A gate.
 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:
 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0  -1 INF INF
 After running your function, the 2D grid should be:
 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4

 * Created by aoshen on 7/15/16.
 */
public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (null == rooms || 0 == rooms.length || 0 == rooms[0].length) return;

        for (int i = 0;i < rooms.length;++ i) {
            for (int j = 0;j < rooms[0].length;++ j) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }

    private void bfs(int[][] rooms, int row, int col) {
        int rows = rooms.length;
        int cols = rooms[0].length;


        Set<Integer> visited = new HashSet<>();
        Queue<Integer> bfsList = new LinkedList<>();
        int dist = 0;

        bfsList.add(row * cols + col);
        visited.add(row * cols + col);

        while (!bfsList.isEmpty()) {
            int size = bfsList.size();

            for (int i = 0;i < size;++ i) {
                int index = bfsList.poll();

                int rIndex = index / cols;
                int cIndex = index % cols;

                if (rooms[rIndex][cIndex] > 0) {
                    rooms[rIndex][cIndex] = Math.min(rooms[rIndex][cIndex], dist);
                }

                if (rIndex + 1 < rows && rooms[rIndex + 1][cIndex] > 0 && !visited.contains((rIndex + 1) * cols + cIndex)) {
                    bfsList.offer((rIndex + 1) * cols + cIndex);
                    visited.add((rIndex + 1) * cols + cIndex);
                }

                if (rIndex - 1 >= 0 && rooms[rIndex - 1][cIndex] > 0 && !visited.contains((rIndex - 1) * cols + cIndex)) {
                    bfsList.offer((rIndex - 1) * cols + cIndex);
                    visited.add((rIndex - 1) * cols + cIndex);
                }

                if (cIndex + 1 < cols && rooms[rIndex][cIndex + 1] > 0 && !visited.contains(rIndex * cols + cIndex + 1)) {
                    bfsList.offer(rIndex * cols + cIndex + 1);
                    visited.add(rIndex * cols + cIndex + 1);
                }

                if (cIndex - 1 >= 0 && rooms[rIndex][cIndex - 1] > 0 && !visited.contains(rIndex * cols + cIndex - 1)) {
                    bfsList.offer(rIndex * cols + cIndex - 1);
                    visited.add(rIndex * cols + cIndex - 1);
                }

            }

            dist ++;
        }
    }
}
