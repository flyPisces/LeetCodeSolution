package ReachableNodesInSubdividedGraph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Starting with an undirected graph (the "original graph") with nodes from 0 to N-1, subdivisions are made to some of the edges.

 The graph is given as follows: edges[k] is a list of integer pairs (i, j, n) such that (i, j) is an edge of the original graph,

 and n is the total number of new nodes on that edge.

 Then, the edge (i, j) is deleted from the original graph, n new nodes (x_1, x_2, ..., x_n) are added to the original graph,

 and n+1 new edges (i, x_1), (x_1, x_2), (x_2, x_3), ..., (x_{n-1}, x_n), (x_n, j) are added to the original graph.

 Now, you start at node 0 from the original graph, and in each move, you travel along one edge.

 Return how many nodes you can reach in at most M moves.



 Example 1:

 Input: edges = [[0,1,10],[0,2,1],[1,2,2]], M = 6, N = 3
 Output: 13
 Explanation:
 The nodes that are reachable in the final graph after M = 6 moves are indicated below.

 Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], M = 10, N = 4
 Output: 23
 */
public class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];

        for (int i = 0;i < N;++ i) {
            Arrays.fill(graph[i], -1);
        }

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        int result = 0;
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        pq.offer(new int[] {0, M});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], step = curr[1];
            if (visited[node]) continue;
            visited[node] = true;
            result ++;

            for (int i = 0;i < N;++ i) {
                if (graph[node][i] > -1) {
                    if (step > graph[node][i] && !visited[i]) {
                        pq.offer(new int[] {i, step - graph[node][i] - 1});
                    }
                    graph[i][node] -= Math.min(step, graph[node][i]);
                    result += Math.min(step, graph[node][i]);
                }
            }
        }

        return result;
    }
}
