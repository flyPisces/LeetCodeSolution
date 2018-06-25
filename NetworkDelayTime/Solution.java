package NetworkDelayTime;

import java.util.*;

/**
 * There are N network nodes, labelled 1 to N.

 Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
 v is the target node, and w is the time it takes for a signal to travel from source to target.

 Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
 If it is impossible, return -1.

 Note:
 N will be in the range [1, 100].
 K will be in the range [1, N].
 The length of times will be in the range [1, 6000].
 All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] delay = new int[N + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        Integer[][] edge = new Integer[101][101];
        for (int[] e : times) edge[e[0]][e[1]] = e[2];
        Queue<Integer> q = new LinkedList<>();
        q.offer(K);
        delay[K] = 0;
        while (!q.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            for (int n = q.size(); n > 0; n--) {
                int u = q.poll();
                for (int v = 1; v <= 100; v++) {
                    if (edge[u][v] != null && delay[u] + edge[u][v] < delay[v]) {
                        if (!set.contains(v)) {
                            set.add(v);
                            q.offer(v);
                        }
                        delay[v] = delay[u] + edge[u][v];
                    }
                }
            }
        }
        int maxdelay = 0;
        for (int i = 1; i <= N; i++)
            maxdelay = Math.max(maxdelay, delay[i]);

        return maxdelay == Integer.MAX_VALUE ? -1 : maxdelay;
    }
}
