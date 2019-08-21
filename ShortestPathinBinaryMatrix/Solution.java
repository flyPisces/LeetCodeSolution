package ShortestPathinBinaryMatrix;

import java.util.*;

/**
 *
 In an N by N square grid, each cell is either empty (0) or blocked (1).

 A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

 Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 C_1 is at location (0, 0) (ie. has value grid[0][0])
 C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 Example 1:

 Input: [[0,1],[1,0]]
 Output: 2
 Example 2:

 Input: [[0,0,0],[1,1,0],[1,1,0]]
 Output: 4
 */
public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0 ,1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int N = grid.length;

        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) return -1;
        boolean[] flag = new boolean[N * N];
        Queue<Integer> queue = new LinkedList<>();

        int layer = 0;
        flag[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;++ i) {
                int top = queue.poll();

                int x = top / N, y = top % N;
                if (x == N - 1 && y == N - 1) return layer + 1;

                for (int[] dir : dirs) {
                    int new_x = x + dir[0], new_y = y + dir[1];

                    if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < N && !flag[new_x * N + new_y] && grid[new_x][new_y] == 0) {
                        queue.offer(new_x * N + new_y);
                        flag[new_x * N + new_y] = true;
                    }
                }
            }

            layer ++;
        }


        return -1;
    }
}
