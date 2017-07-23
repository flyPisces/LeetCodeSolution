package AndroidUnlockPatterns;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.

 Rules for a valid pattern:
 Each pattern must connect at least m keys and at most n keys.
 All the keys must be distinct.
 If the line connecting two consecutive keys in the pattern passes through any other keys,
 the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 The order of keys used matters.

 Explanation:
 | 1 | 2 | 3 |
 | 4 | 5 | 6 |
 | 7 | 8 | 9 |
 Invalid move: 4 - 1 - 3 - 6
 Line 1 - 3 passes through key 2 which had not been selected in the pattern.

 Invalid move: 4 - 1 - 9 - 2
 Line 1 - 9 passes through key 5 which had not been selected in the pattern.

 Valid move: 2 - 4 - 1 - 3 - 6
 Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

 Valid move: 6 - 5 - 4 - 1 - 9 - 2
 Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

 Example:
 Given m = 1, n = 1, return 9.

 * Created by aoshen on 7/23/16.
 */
public class Solution {
    private int result = 0;

    private boolean isValid(boolean[] visited, int from, int to) {
        if (from == to) return false;

        int smaller = Math.min(from, to);
        int bigger = Math.max(from, to);

        if ((smaller == 1 && bigger == 9) || (smaller == 3 && bigger == 7)) {
            return visited[5] &&  !visited[to];
        }

        if ((smaller == 1 || smaller == 4 || smaller == 7) && bigger == smaller + 2) {
            return visited[smaller + 1] && !visited[to];
        }

        if ((smaller == 1 || smaller == 2 || smaller == 3) && bigger == smaller + 6) {
            return visited[smaller + 3] && !visited[to];
        }

        return !visited[to];
    }

    private void find(boolean[] visited, int step, int from, int m, int n) {
        if (step == n) {
            ++ result;
            return;
        }

        if (step >= m) {
            ++ result;
        }

        for (int i = 1;i <= 9;++ i) {
            if (isValid(visited, from, i)) {
                visited[i] = true;
                find(visited, step + 1, i, m, n);
                visited[i] = false;
            }
        }
    }

    public int numberOfPatterns(int m, int n) {
        boolean[] visited = new boolean[10];

        for (int i = 1;i <= 9;++ i) {
            visited[i] = true;
            find(visited, 1, i, m, n);
            visited[i] = false;
        }

        return result;
    }
}
