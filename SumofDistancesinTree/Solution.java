package SumofDistancesinTree;

import java.util.*;

/**
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.

 The ith edge connects nodes edges[i][0] and edges[i][1] together.

 Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

 Example 1:

 Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 Output: [8,12,6,10,10,10]
 Explanation:
 Here is a diagram of the given tree:
 0
 / \
 1   2
 /|\
 3 4 5
 We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 */
public class Solution {
    List<Set<Integer>> graph;
    int[] ans;
    int[] count;
    int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        ans = new int[N];
        count = new int[N];
        graph = new ArrayList<>();

        Arrays.fill(count, 1);
        for (int i = 0;i < N;++ i) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }

    private void dfs1(int node, int parent) {
        for (int nei : graph.get(node)) {
            if (nei != parent) {
                dfs1(nei, node);
                count[node] += count[nei];
                ans[node] += ans[nei] + count[nei];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int nei : graph.get(node)) {
            if (nei != parent) {
                ans[nei] = ans[node] - count[nei] + N - count[nei];
                dfs2(nei, node);
            }
        }
    }
}
