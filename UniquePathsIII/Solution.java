package UniquePathsIII;

/**
 * On a 2-dimensional grid, there are 4 types of squares:

 1 represents the starting square.  There is exactly one starting square.
 2 represents the ending square.  There is exactly one ending square.
 0 represents empty squares we can walk over.
 -1 represents obstacles that we cannot walk over.
 Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.



 Example 1:

 Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 Output: 2
 Explanation: We have the following two paths:
 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 Example 2:

 Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 Output: 4
 Explanation: We have the following four paths:
 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 Example 3:

 Input: [[0,1],[2,0]]
 Output: 0
 Explanation:
 There is no path that walks over every empty square exactly once.
 Note that the starting and ending square can be anywhere in the grid.
 */
public class Solution {
    int R, C;
    Integer[][][] memo;
    int tr, tc, target;
    int[][] grid;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        target = 0;

        int sr = 0, sc = 0;
        for (int r = 0;r < R;++ r) {
            for (int c = 0;c < C;++ c) {
                if (grid[r][c] % 2 == 0) {
                    target |= code(r, c);
                }

                if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                } else if (grid[r][c] == 2) {
                    tr = r;
                    tc = c;
                }
            }
        }

        memo = new Integer[R][C][1 << R * C];

        return dp(sr, sc, target);
    }

    private int code(int r, int c) {
        return 1 << (r * C + c);
    }

    private Integer dp(int r, int c, int todo) {
        if (memo[r][c][todo] != null) {
            return memo[r][c][todo];
        }

        if (r == tr && c == tc) {
            return  todo == 0 ? 1 : 0;
        }

        int ans = 0;

        for (int k = 0;k < 4;++ k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if ((todo & code(nr, nc)) != 0) {
                    ans += dp(nr, nc, todo ^ code(nr, nc));
                }
            }
        }
        memo[r][c][todo] = ans;

        return ans;
    }
}
