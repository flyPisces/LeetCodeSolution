package PossibleBipartition;

import java.util.*;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

 Each person may dislike some other people, and they should not go into the same group.

 Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

 Return true if and only if it is possible to split everyone into two groups in this way.



 Example 1:

 Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 Output: true
 Explanation: group1 [1,4], group2 [2,3]
 Example 2:

 Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 Output: false
 Example 3:

 Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 Output: false
 */
public class Solution {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        for (int i = 1;i <= N;++ i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        color = new HashMap<>();

        for (int i = 1;i <= N;++ i) {
            if (!color.containsKey(i) && !dfs(i, 0)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int val) {
        if (color.containsKey(node)) {
            return color.get(node) == val;
        }

        color.put(node, val);

        for (Integer neighbor : graph[node]) {
            if (!dfs(neighbor, val ^ 1)) {
                return false;
            }
        }

        return true;
    }
}
