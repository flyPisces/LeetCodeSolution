package IsGraphBipartite;

import java.util.Arrays;

/**
 * Given a graph, return true if and only if it is bipartite.

 Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

 The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

 Example 1:
 Input: [[1,3], [0,2], [1,3], [0,2]]
 Output: true
 Explanation:
 The graph looks like this:
 0----1
 |    |
 |    |
 3----2
 We can divide the vertices into two groups: {0, 2} and {1, 3}.
 Example 2:
 Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 Output: false
 Explanation:
 The graph looks like this:
 0----1
 | \  |
 |  \ |
 3----2
 We cannot find a way to divide the set of nodes into two independent ubsets.
 */
public class Solution {
    int N = 0;

    public boolean isBipartite(int[][] graph) {
        N = graph.length;
        int[] colors = new int[N];
        Arrays.fill(colors, -1);

        for (int i = 0;i < N;++ i) {
            if (colors[i] == -1 && !dfs(graph, colors, 0, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int idx) {
        if (colors[idx] != -1) {
            return colors[idx] == color;
        }

        colors[idx] = color;
        for (int neighbor : graph[idx]) {
            if (!dfs(graph, colors, 1 - color, neighbor)) {
                return false;
            }
        }

        return true;
    }
}
