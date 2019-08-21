package EscapeaLargeMaze;

import java.util.*;

/**
 * In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.

 We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.

 Return true if and only if it is possible to reach the target square through a sequence of moves.



 Example 1:

 Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 Output: false
 Explanation:
 The target square is inaccessible starting from the source square, because we can't walk outside the grid.
 Example 2:

 Input: blocked = [], source = [0,0], target = [999999,999999]
 Output: true
 Explanation:
 Because there are no blocked cells, it's possible to reach the target square.
 */
public class Solution {
    int[][] dirs = new int[][]{{0 , 1}, {0, - 1}, {1, 0}, {-1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked == null || blocked.length == 0) return true;

        Set<String> blockedSets = new HashSet<>();

        for (int[] block : blocked) {
            StringBuilder sb = new StringBuilder();
            sb.append(block[0]);
            sb.append(',');
            sb.append(block[1]);

            blockedSets.add(sb.toString());
        }

        return bfs(source, target, blockedSets) && bfs(target, source, blockedSets);
    }

    private boolean bfs(int[] source, int[] target, Set<String> blockedSets) {
        Set<String> visitedSets = new HashSet<>();

        int MAX = blockedSets.size();
        int level = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;++ i) {
                int[] arr = queue.poll();

                int x = arr[0], y = arr[1];
                if (x == target[0] && y == target[1]) return true;

                for (int[] dir : dirs) {
                    int nx = dir[0] + x, ny = dir[1] + y;

                    String nStr = nx + "," + ny;
                    if (nx < 0 || nx >= 1000000 || ny < 0 || ny >= 1000000 ||
                            visitedSets.contains(nStr) || blockedSets.contains(nStr)) {
                        continue;
                    }

                    queue.add(new int[] {nx, ny});
                    visitedSets.add(nStr);
                }
            }

            level += 1;
            if (level == MAX) break;
        }

        return level == MAX ? true : false;
    }
}
