package NumberofIslandsTwo;

import java.util.*;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]

 * Created by aoshen on 7/23/16.
 */
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> results = new ArrayList<>();

        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return results;
        }

        int[] dp = new int[m * n];
        Arrays.fill(dp, -1);

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int count = 0;
        for (int i = 0;i < positions.length;++ i) {
            int index = positions[i][0] * n + positions[i][1];
            dp[index] = index;
            count ++;

            for (int j = 0;j < directions.length;++ j) {
                int x = positions[i][0] + directions[j][0];
                int y = positions[i][1] + directions[j][1];

                if (x >= 0 && x < m && y >= 0 && y < n && dp[x * n + y] != -1) {
                    int root = getRoot(dp, x * n + y);

                    if (root != index) {
                        dp[root] = index;
                        count --;
                    }
                }

            }

            results.add(count);
        }

        return results;
    }

    private int getRoot(int[] dp, int idx) {
        while (idx != dp[idx]) {
            dp[idx] = dp[dp[idx]];
            idx = dp[idx];
        }

        return idx;
    }
}
