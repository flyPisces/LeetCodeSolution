package MinimumMovestoReachTargetwithRotations;

import java.util.*;

/**
 * In an n*n grid, there is a snake that spans 2 cells and starts moving from the top left corner at (0, 0) and (0, 1). The grid has empty cells represented by zeros and blocked cells represented by ones. The snake wants to reach the lower right corner at (n-1, n-2) and (n-1, n-1).
 *
 * In one move the snake can:
 *
 * Move one cell to the right if there are no blocked cells there. This move keeps the horizontal/vertical position of the snake as it is.
 * Move down one cell if there are no blocked cells there. This move keeps the horizontal/vertical position of the snake as it is.
 * Rotate clockwise if it's in a horizontal position and the two cells under it are both empty. In that case the snake moves from (r, c) and (r, c+1) to (r, c) and (r+1, c)
 */
public class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length, moves = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.offer(new int[] {0, 1});
        seen.add("0-1");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] span = q.poll();
                int first = span[0], second = span[1], x1 = first / n, y1 = first % n, x2 = second / n, y2 = second % n;
                if (x1 == n - 1 && y1 == n - 2 && x2 == n - 1 && y2 == n - 1) return moves;

                if (x1 == x2) { // horizontal
                    if (y2 + 1 < n && grid[x2][y2 + 1] == 0) move(q, second, second + 1, seen); // right
                    if (x2 + 1 < n && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0) {
                        move(q, first + n, second + n, seen); // down
                        move(q, first, first + n, seen); // clockwise
                    }
                }

                if (y1 == y2) { // vertical
                    if (x2 + 1 < n && grid[x2 + 1][y2] == 0) move(q, second, second + n, seen); // down
                    if (y2 + 1 < n && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0) {
                        move(q, first + 1, second + 1, seen); // right
                        move(q, first, first + 1, seen); // counter clockwise
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private void move(Queue<int[]> q, int first, int second, Set<String> seen) {
        if (!seen.contains(first + "-" + second)) {
            q.offer(new int[] { first, second });
            seen.add(first + "-" + second);
        }
    }
}
