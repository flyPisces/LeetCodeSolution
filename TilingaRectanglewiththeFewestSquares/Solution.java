package TilingaRectanglewiththeFewestSquares;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 Given a rectangle of size n x m, find the minimum number of integer-sided squares that tile the rectangle.

sInput: n = 2, m = 3
 Output: 3
 Explanation: 3 squares are necessary to cover the rectangle.
 2 (squares of 1x1)
 1 (square of 2x2)x


 */
public class Solution {
    int result = Integer.MAX_VALUE;
    Map<Long, Integer> mapping = new HashMap<>();

    public int tilingRectangle(int n, int m) {
        if (n < m) {
            int temp = m;
            m = n;
            n = temp;
        }

        int[] dp = new int[n + 1];
        int[] dimensions = new int[n + 1];
        Arrays.fill(dimensions, 1);
        for (int i = 1;i <= n;++ i) {
            dimensions[i] = (m + 1) * dimensions[i - 1];
        }

        dfs(dp, dimensions, m, n, 0);

        return result;
    }

    private void dfs(int[] dp, int[] dimensions, int m, int n, int count) {
        if (count >= result) return;

        boolean isFull = true;
        int minHeight = Integer.MAX_VALUE, pos = -1;
        for (int i = 1;i <= n;++ i) {
            if (dp[i] != m) {
                isFull = false;
            }

            if (dp[i] < minHeight) {
                minHeight = dp[i];
                pos = i;
            }
        }

        if (isFull) {
            result = Math.min(count, result);
            return;
        }

        long key = 0;
        for (int i = 1;i <= n;++ i) {
            key += dp[i] * dimensions[i];
        }

        if (mapping.get(key) != null && mapping.get(key) <= count) return;
        mapping.put(key, count);

        int end = pos;
        while (end + 1 <= n && dp[end + 1] == dp[pos] && (end + 1 - pos + 1 + minHeight <= m)) ++ end;
        for (int j = end;j >= pos;-- j) {
            int len = j - pos + 1;

            for (int k = pos;k <= j;++ k) {
                dp[k] += len;
            }

            dfs(dp, dimensions, m, n, count + 1);

            for (int k = pos;k <= j;++ k) {
                dp[k] -= len;
            }
        }
    }
}
