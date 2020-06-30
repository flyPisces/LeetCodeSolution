package TreeDiameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.
 *
 * The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each node has labels in the set {0, 1, ..., edges.length}.
 */
public class Solution {
    int diameter = 0;

    public int treeDiameter(int[][] edges) {
        int N = edges.length + 1;
        List<Integer>[] graph = new List[N];
        for (int i = 0;i < N;++ i) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        dfs(0, graph, -1);
        return diameter;
    }

    private int dfs(int curr, List<Integer>[] graph, int parent) {
        int firstLongPath = 0, secondLongPath = 0;
        for (int child : graph[curr]) {
            if (child == parent) continue;
            int childPath = dfs(child, graph, curr);
            if (childPath > firstLongPath) {
                secondLongPath = firstLongPath;
                firstLongPath = childPath;
            } else if (childPath > secondLongPath) {
                secondLongPath = childPath;
            }
        }

        int longest = firstLongPath + secondLongPath + 1;
        diameter = Math.max(diameter, longest - 1);

        return firstLongPath + 1;
    }
}
