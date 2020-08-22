package CampusBikesTwo;

/**
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 *
 * We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned bike is minimized.
 *
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 *
 * Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
 *
 *
 */
public class Solution {
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, 0, 0, new boolean[bikes.length]);
        return min;
    }

    private void dfs(int[][] workers, int[][] bikes, int sum, int i, boolean[] used) {
        if (i == workers.length) {
            min = Math.min(min, sum);
            return;
        }

        if (sum >= min) return;

        for (int j = 0;j < used.length;++ j) {
            if (used[j]) continue;

            used[j] = true;

            dfs(workers, bikes, sum + distance(workers[i], bikes[j]), i + 1, used);

            used[j] = false;
        }
    }

    private int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
