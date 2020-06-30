package CheckifThereisaValidPathinaGrid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
 * 1 which means a street connecting the left cell and the right cell.
 * 2 which means a street connecting the upper cell and the lower cell.
 * 3 which means a street connecting the left cell and the lower cell.
 * 4 which means a street connecting the right cell and the lower cell.
 * 5 which means a street connecting the left cell and the upper cell.
 * 6 which means a street connecting the right cell and the upper cell.
 */
public class Solution {
    public boolean hasValidPath(int[][] grid) {
        int[][][] dirs = new int[][][] {
                {{0, -1}, {0, 1}},
                {{-1, 0}, {1, 0}},
                {{0, -1}, {1, 0}},
                {{0, 1}, {1, 0}},
                {{0, -1}, {-1, 0}},
                {{0, 1}, {-1, 0}}
        };

        int ROWS = grid.length, COLS = grid[0].length, target = ROWS * COLS - 1;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (top == target) return true;
            int row = top / COLS, col = top % COLS, val = grid[row][col];

            for (int[] dir : dirs[val - 1]) {
                int newRow = dir[0] + row, newCol = dir[1] + col, newPos = newRow * COLS + newCol;

                if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS || visited.contains(newRow * COLS + newCol)) continue;

                for (int[] backDir : dirs[grid[newRow][newCol] - 1]) {
                    if (newRow + backDir[0] == row && newCol + backDir[1] == col) {
                        queue.offer(newPos);
                        visited.add(newPos);
                    }
                }
            }
        }

        return false;
    }
}
