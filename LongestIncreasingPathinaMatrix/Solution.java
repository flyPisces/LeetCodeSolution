package LongestIncreasingPathinaMatrix;

/**
 * Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 *
 * Created by aoshen on 5/29/16.
 */
public class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dis = new int[row][col];

        for (int i = 0;i < row;++ i) {
            for (int j = 0;j < col;++ j) {
                result = Math.max(result, dfs(row, col, i, j, dis, matrix));
            }
        }

        return result;
    }

    private int dfs(int row, int col, int x, int y, int[][] dis, int[][] matrix) {
        if (dis[x][y] != 0) return dis[x][y];

        for (int i = 0;i < 4;++ i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < row && ny < col && matrix[nx][ny] > matrix[x][y]) {
                dis[x][y] = Math.max(dis[x][y], dfs(row, col, nx, ny, dis, matrix));
            }

        }

        return ++dis[x][y];
    }
}
