package ShortestDistancefromAllBuildings;

import java.util.*;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.
    For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

    1 - 0 - 2 - 0 - 1
    |   |   |   |   |
    0 - 0 - 0 - 0 - 0
    |   |   |   |   |
    0 - 0 - 1 - 0 - 0

    The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

 * Created by aoshen on 7/17/16.
 */
public class Solution {
    public int shortestDistance(int[][] grid) {
        int shortest = Integer.MAX_VALUE;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ROWS = grid.length;
        int COLUMNS = grid[0].length;

        int[][] distances = new int[ROWS][COLUMNS];
        int[][] buildings = new int[ROWS][COLUMNS];

        int numOfBuildings = 0;

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLUMNS;++ j) {
                if (grid[i][j] == 1) {
                    numOfBuildings ++;
                    bfs(grid, i, j, distances, buildings);
                }
            }
        }

        for (int i = 0;i < ROWS;++ i) {
            for (int j = 0;j < COLUMNS;++ j) {
                if (buildings[i][j] == numOfBuildings && distances[i][j] > 0 && grid[i][j] == 0) {
                    shortest = Math.min(shortest, distances[i][j]);
                }
            }
        }

        shortest = (shortest == Integer.MAX_VALUE ? -1 : shortest);

        return shortest;
    }

    private void bfs(int[][] grid, int row, int col, int[][] distances, int[][] buildings) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int ROWS = grid.length;
        int COLUMNS = grid[0].length;

        int dist = 0;
        visited.add(row * COLUMNS + col);
        queue.add(row * COLUMNS + col);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0;i < size;++ i) {
                int index = queue.poll();

                int r = index / COLUMNS;
                int c = index % COLUMNS;

                if (grid[r][c] == 0) {
                    buildings[r][c]++;
                    distances[r][c] += dist;
                }

                if (r + 1 < ROWS && grid[r + 1][c] == 0 && !visited.contains((r + 1) * COLUMNS + c)) {
                    queue.offer((r + 1) * COLUMNS + c);
                    visited.add((r + 1) * COLUMNS + c);
                }

                if (r - 1 >= 0 && grid[r - 1][c] == 0 && !visited.contains((r - 1) * COLUMNS + c)) {
                    queue.offer((r - 1) * COLUMNS + c);
                    visited.add((r - 1) * COLUMNS + c);
                }

                if (c - 1 >= 0 && grid[r][c - 1] == 0 && !visited.contains(r * COLUMNS + c - 1)) {
                    queue.offer(r * COLUMNS + c - 1);
                    visited.add(r * COLUMNS + c - 1);
                }

                if (c + 1 < COLUMNS && grid[r][c + 1] == 0 && !visited.contains(r * COLUMNS + c + 1)) {
                    queue.offer(r * COLUMNS + c + 1);
                    visited.add(r * COLUMNS + c + 1);
                }
            }

            dist ++;
        }
    }
}
