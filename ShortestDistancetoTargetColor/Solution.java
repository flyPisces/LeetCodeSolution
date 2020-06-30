package ShortestDistancetoTargetColor;

import java.util.*;

/**
 * You are given an array colors, in which there are three colors: 1, 2 and 3.
 *
 * You are also given some queries. Each query consists of two integers i and c, return the shortest distance between the given index i and the target color c. If there is no solution return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
 * Output: [3,0,3]
 * Explanation:
 * The nearest 3 from index 1 is at index 4 (3 steps away).
 * The nearest 2 from index 2 is at index 2 itself (0 steps away).
 * The nearest 1 from index 6 is at index 3 (3 steps away).
 * Example 2:
 *
 * Input: colors = [1,2], queries = [[0,3]]
 * Output: [-1]
 * Explanation: There is no 3 in the array.
 */

public class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer> results = new ArrayList<>();

        int N = colors.length;
        int[][] leftDistances = new int[4][N], rightDistances = new int[4][N];

        for (int i = 0;i < 4; ++ i) {
            Arrays.fill(leftDistances[i], -1);
            Arrays.fill(rightDistances[i], -1);
        }

        for (int i = 0, j = N - 1;i < N && j >= 0;++ i, -- j) {
            leftDistances[colors[i]][i] = i;
            rightDistances[colors[i]][i] = i;
            leftDistances[colors[j]][j] = j;
            rightDistances[colors[j]][j] = j;

            for (int k = 1;k <= 3;++ k) {
                if (colors[i] == k) continue;

                if (i > 0) leftDistances[k][i] = leftDistances[k][i - 1];
            }

            for (int k = 1;k <= 3;++ k) {
                if (colors[j] == k) continue;

                if (j < N - 1) rightDistances[k][j] = rightDistances[k][j + 1];
            }
        }

        for (int[] query : queries) {
            int idx = query[0], color = query[1];

            if (leftDistances[color][idx] == -1 && rightDistances[color][idx] == -1) {
                results.add(-1);
            } else if (leftDistances[color][idx] == -1) {
                results.add(rightDistances[color][idx] - idx);
            } else if (rightDistances[color][idx] == -1) {
                results.add(idx - leftDistances[color][idx]);
            } else {
                results.add(Math.min(idx - leftDistances[color][idx], rightDistances[color][idx] - idx));
            }
        }

        return results;
    }
}
