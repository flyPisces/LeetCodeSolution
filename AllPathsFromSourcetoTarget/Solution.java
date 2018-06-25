package AllPathsFromSourcetoTarget;

import java.util.*;

/**
 * Given a directed, acyclic graph of N nodes.
 * Find all possible paths from node 0 to node N-1, and return them in any order.

 The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
 graph[i] is a list of all nodes j for which the edge (i, j) exists.

 Example:
 Input: [[1,2], [3], [3], []]
 Output: [[0,1,3],[0,2,3]]
 Explanation: The graph looks like this:
 0--->1
 |    |
 v    v
 2--->3
 There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        dfs(results, result, graph, 0, graph.length - 1);

        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> result, int[][] graph, int source, int dest) {
        if (dest == source) {
            result.add(source);
            results.add(new ArrayList<>(result));
            result.remove(result.size() - 1);

            return;
        }

        result.add(source);

        for (int neighbor : graph[source]) {
            dfs(results, result, graph, neighbor, dest);
        }

        result.remove(result.size() - 1);
    }
}
