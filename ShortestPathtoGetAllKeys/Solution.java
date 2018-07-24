package ShortestPathtoGetAllKeys;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.

 We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.

 For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

 Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.



 Example 1:

 Input: ["@.a.#","###.#","b.A.B"]
 Output: 8
 Example 2:

 Input: ["@..aA","..B#.","....b"]
 Output: 6
 */
public class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length(), max = -1, x= - 1, y = -1;

        for (int i = 0;i < m;++ i) {
            for (int j = 0;j < n;++ j) {
                if (grid[i].charAt(j) == '@') {
                    x = i;
                    y = j;
                }

                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    max = Math.max(max, grid[i].charAt(j) - 'a' + 1);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<State> list = new LinkedList<>();

        State start = new State(0, x, y);
        visited.add("0," + x + "," + y);
        list.offer(start);

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0;

        while (!list.isEmpty()) {
            int size = list.size();

            for (int i = 0;i < size;++ i) {
                State state = list.poll();

                if (state.key == (1 << max) - 1) {
                    return step;
                }

                for (int[] arr : dirs) {
                    int k = state.x + arr[0];
                    int j = state.y + arr[1];
                    int key = state.key;

                    if (k >= 0 && k < m && j >= 0 && j < n) {
                        char c = grid[k].charAt(j);

                        if (c == '#') continue;

                        if (c >= 'a' && c <= 'f') {
                            key |= 1 << (c - 'a');
                        }

                        if (c >= 'A' && c <= 'F' && ((key >> (c - 'A')) & 1) == 0) {
                            continue;
                        }

                        if (!visited.contains(key + "," + k + "," + j)) {
                            visited.add(key + "," + k + "," + j);
                            list.add(new State(key, k, j));
                        }
                    }
                }

            }
            step ++;
        }

        return -1;
    }
}

class State {
    int key;
    int x;
    int y;

    public State(int key, int x, int y) {
        this.key = key;
        this.x = x;
        this.y = y;
    }
}
