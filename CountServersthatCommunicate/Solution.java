package CountServersthatCommunicate;

/**
 *
 You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

 Return the number of servers that communicate with any other server.
 */
public class Solution {
    public int countServers(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        int[] rows = new int[M], cols = new int[N];

        int result = 0;
        for (int i = 0;i < M;++ i) {
            for (int j = 0;j < N;++ j) {
                if (grid[i][j] == 1) {
                    rows[i] ++;
                    cols[j] ++;
                    result ++;
                }
            }
        }

        for (int i = 0;i < M;++ i) {
            for (int j = 0;j < N;++ j) {
                if (rows[i] == 1 && cols[j] == 1 && grid[i][j] == 1) {
                    result --;
                }
            }
        }

        return result;
    }
}
