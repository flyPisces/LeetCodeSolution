package MinimumKnightMoves;

import java.util.*;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 */

public class Solution {
    private final int[] dirs = new int[]{2, 1, 2, -1, 2, -1, -2, 1, 2};

    public int minKnightMoves(int x, int y) {
        int MOD = 601;
        int absX = Math.abs(x), absY = Math.abs(y);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        for (int steps = 0;!queue.isEmpty();++ steps) {
            for (int sz = queue.size();sz > 0;-- sz) {
                int i = queue.peek() / MOD, j = queue.poll() % MOD;

                if (i == absX && j == absY) return steps;

                for (int k = 0;k < 8;++ k) {
                    int newX = i + dirs[k], newY = j + dirs[k + 1];

                    if (newX >= -2 && newY >= -2 && !seen.contains(newX * MOD + newY)) {
                        queue.offer(newX * MOD + newY);
                        seen.add(newX * MOD + newY);
                    }
                }
            }
        }

        return -1;
    }
}
