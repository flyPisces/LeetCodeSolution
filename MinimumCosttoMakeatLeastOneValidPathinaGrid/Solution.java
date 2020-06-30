package MinimumCosttoMakeatLeastOneValidPathinaGrid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
 Notice that there could be some invalid signs on the cells of the grid which points outside the grid.

 You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.

 You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

 Return the minimum cost to make the grid have at least one valid path.


 */
public class Solution {
    int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0;i < M;++ i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int cost = 0;
        Queue<int[]> bfs = new LinkedList<>();
        dfs(grid, dp, 0, 0, cost, bfs);

        while (!bfs.isEmpty()) {
            cost ++ ;
            for (int size = bfs.size();size > 0;-- size) {
                int[] top = bfs.poll();
                int r = top[0], c = top[1];
                for (int[] d : DIR) {
                    dfs(grid, dp, r + d[0], c + d[1], cost, bfs);
                }
            }
        }

        return dp[M - 1][N - 1];
    }

    private void dfs(int[][] grid, int[][] dp, int r, int c, int cost, Queue<int[]> bfs) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || dp[r][c] != Integer.MAX_VALUE) return;
        dp[r][c] = cost;
        bfs.offer(new int[] {r, c});

        int idx = grid[r][c] - 1;
        dfs(grid, dp, r + DIR[idx][0], c + DIR[idx][1], cost, bfs);
    }
}
