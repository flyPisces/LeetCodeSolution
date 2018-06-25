package NumberofConnectedComponentsinanUndirectedGraph;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.

 Example 1:
 0          3
 |          |
 1 --- 2    4
 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

 Example 2:
 0           4
 |           |
 1 --- 2 --- 3
 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

 Note:
 You can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0, 1] is the same as [1, 0] and
 thus will not appear together in edges.

 * Created by aoshen on 7/29/16.
 */
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null) return 0;

        int count = n;
        int[] dp = new int[n];
        for (int i = 0;i < n;++ i) {
            dp[i] = i;
        }

        for (int[] edge : edges) {
            int fromRoot = root(dp, edge[0]);
            int toRoot = root(dp, edge[1]);

            if (fromRoot != toRoot) {
                count --;
                dp[fromRoot] = toRoot;
            }
        }

        return count;
    }

    public int root(int[] dp, int index) {
        while (index != dp[index]) {
            dp[index] = dp[dp[index]];
            index = dp[index];
        }

        return index;
    }
}
