package GraphValidTree;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 * Created by aoshen on 7/29/16.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) return false;

        if (edges.length != n - 1) return false;

        int[] root = new int[n];
        for (int i = 0;i < n;++ i) {
            root[i] = i;
        }

        for (int[] edge : edges) {
            int from = root[edge[0]];
            int to = root[edge[1]];

            if (from == to) {
                continue;
            }

            for (int i = 0;i < n;++ i) {
                if (root[i] == from) {
                    root[i] = to;
                }
            }
        }

        for (int i = 0;i < n - 1;++ i) {
            if (root[i] != root[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
