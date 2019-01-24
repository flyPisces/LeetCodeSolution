package RegionsCutBySlashes;

/**
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

 (Note that backslash characters are escaped, so a \ is represented as "\\".)

 Return the number of regions.



 Example 1:

 Input:
 [
 " /",
 "/ "
 ]
 Output: 2
 Explanation: The 2x2 grid is as follows:

 Example 2:

 Input:
 [
 " /",
 "  "
 ]
 Output: 1
 Explanation: The 2x2 grid is as follows:

 Example 3:

 Input:
 [
 "\\/",
 "/\\"
 ]
 Output: 4
 Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
 The 2x2 grid is as follows:

 Example 4:

 Input:
 [
 "/\\",
 "\\/"
 ]
 Output: 5
 Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
 The 2x2 grid is as follows:

 Example 5:

 Input:
 [
 "//",
 "/ "
 ]
 Output: 3
 Explanation: The 2x2 grid is as follows:

 */
public class Solution {

    int N, result = 0;
    int[] dp;

    public int regionsBySlashes(String[] grid) {
        N = grid.length;
        dp = new int[4 * N * N];
        result = 4 * N * N;

        for (int i = 0;i < 4 * N * N;++ i) {
            dp[i] = i;
        }

        for (int i = 0;i < N;++ i) {
            for (int j = 0;j < N;++ j) {
                if (i > 0) {
                    union(g(i - 1, j, 2), g(i, j, 0));
                }
                if (j > 0) {
                    union(g(i , j - 1, 1), g(i , j, 3));
                }

                if (grid[i].charAt(j) != '/') {
                    union(g(i , j, 0), g(i , j,  1));
                    union(g(i , j, 2), g(i , j,  3));
                }

                if (grid[i].charAt(j) != '\\') {
                    union(g(i , j, 0), g(i , j,  3));
                    union(g(i , j, 2), g(i , j,  1));
                }
            }
        }
        return result;
    }

    private int dfs(int x) {
        if (x != dp[x]) {
            dp[x] = dfs(dp[x]);
        }

        return dp[x];
    }

    private void union(int x, int y) {
        int root1 = dfs(x), root2 = dfs(y);

        if (root1 != root2) {
            dp[root1] = root2;
            -- result;
        }
    }

    private int g(int x, int y, int z) {
        return 4 * (N * x + y) + z;
    }
}
