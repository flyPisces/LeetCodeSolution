package BricksFallingWhenHit;

/**
 * We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.

 We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

 Return an array representing the number of bricks that will drop after each erasure in sequence.

 Example 1:
 Input:
 grid = [[1,0,0,0],[1,1,1,0]]
 hits = [[1,0]]
 Output: [2]
 Explanation:
 If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 Example 2:
 Input:
 grid = [[1,0,0,0],[1,1,0,0]]
 hits = [[1,1],[1,0]]
 Output: [0,0]
 Explanation:
 When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 */
public class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[][] arr = new int[grid.length][grid[0].length];

        for (int i = 0;i < grid.length;++ i) {
            for (int j = 0;j < grid[0].length;++ j) {
                arr[i][j] = grid[i][j];
            }
        }

        for (int[] hit : hits) {
            arr[hit[0]][hit[1]] = 0;
        }

        int R = grid.length, C = grid[0].length;
        DSU dsu = new DSU(R * C + 1);

        for (int i = 0;i < R;++ i) {
            for (int j = 0;j < C;++ j) {
                if (arr[i][j] == 1) {
                    int idx = i * C + j;
                    if (i == 0) {
                        dsu.union(idx, R * C);
                    }

                    if (i > 0 && arr[i - 1][j] == 1) {
                        dsu.union(idx, (i - 1) * C + j);
                    }

                    if (j > 0 && arr[i][j - 1] == 1) {
                        dsu.union(idx, i * C + j - 1);
                    }
                }
            }
        }

        int t = hits.length;
        int[] ans = new int[t --];

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while (t >= 0) {
            int r = hits[t][0], c = hits[t][1];
            int preRoof = dsu.top();
            if (grid[r][c] == 0) {
                t --;
            } else {
                int idx = r * C + c;

                for (int k = 0;k < 4;++ k) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && arr[nr][nc] == 1) {
                        dsu.union(idx, nr * C + nc);
                    }
                }

                if (r == 0) {
                    dsu.union(idx, R * C);
                }
                arr[r][c] = 1;

                ans[t --] = Math.max(0, dsu.top() - preRoof - 1);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{1,1,1,0}};
        int[][] hit = {{1,0}};

        Solution sol = new Solution();
        sol.hitBricks(grid, hit);
    }
}
