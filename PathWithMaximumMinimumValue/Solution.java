package PathWithMaximumMinimumValue;

import java.util.*;

/**
 * Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
 *
 * The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
 *
 * A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).
 *
 *
 */
public class Solution {
    public int maximumMinimumPath(int[][] A) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int ROWS = A.length, COLS = A[0].length;
        pq.offer(new int[] {A[0][0], 0, 0});
        int maxScore = A[0][0];
        A[0][0] = -1;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int currVal = top[0], currX = top[1], currY = top[2];
            maxScore = Math.min(maxScore, currVal);

            if (currX == ROWS - 1 && currY == COLS - 1) break;

            for (int[] dir: dirs) {
                int newX = currX + dir[0], newY = currY + dir[1];

                if (newX >= 0 && newX < ROWS && newY >= 0 && newY < COLS
                        && A[newX][newY] >= 0) {
                    pq.offer(new int[] {A[newX][newY], newX, newY});
                    A[newX][newY] = -1;
                }
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maximumMinimumPath(new int[][] {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}}));
    }
}
