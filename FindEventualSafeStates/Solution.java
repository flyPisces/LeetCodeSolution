package FindEventualSafeStates;

import java.util.*;

/**
 * In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

 Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

 Which nodes are eventually safe?  Return them as an array in sorted order.

 The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

 Example:
 Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 Output: [2,4,5,6]
 Here is a diagram of the above graph.

 */
public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;

        List<Set<Integer>> neighors = new ArrayList<>();
        List<Set<Integer>> rneighors = new ArrayList<>();

        for (int i = 0;i < N;++ i) {
            neighors.add(new HashSet<Integer>());
            rneighors.add(new HashSet<Integer>());
        }

        for (int i = 0;i < N;++ i) {
            for (int j : graph[i]) {
                neighors.get(i).add(j);
                rneighors.get(j).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i < N;++ i) {
            if (neighors.get(i).size() == 0) {
                queue.add(i);
            }
        }

        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            int safe = queue.poll();
            results.add(safe);

            for (int i : rneighors.get(safe)) {
                neighors.get(i).remove(safe);

                if (neighors.get(i).isEmpty()) {
                    queue.add(i);
                }
            }
        }

        Collections.sort(results);
        return results;
    }
}
