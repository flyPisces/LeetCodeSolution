package AllPathsfromSourceLeadtoDestination;

import java.util.*;

/**
 *
 Given the edges of a directed graph, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually end at destination, that is:

 At least one path exists from the source node to the destination node
 If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 The number of possible paths from source to destination is a finite number.
 Return true if and only if all roads from source lead to destination.


 */
public class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = buildDigraph(n, edges);

        return dfs(graph, source, destination, new int[n]);
    }

    private boolean dfs(List<Integer>[] graph, int from, int destination, int[] state) {
        if (state[from] != 0) return state[from] == 2;
        if (graph[from].size() == 0) return from == destination;

        state[from] = 1;

        for (int next : graph[from]) {
            if (!dfs(graph, next, destination, state)) return false;
        }

        state[from] = 2;

        return true;
    }

    private List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] results = new List[n];

        for (int i = 0;i < n;++ i) {
            results[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            results[edge[0]].add(edge[1]);
        }

        return results;

    }
}
