package MinimumTimetoCollectAllApplesinaTree;

import java.util.*;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices. You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend in order to collect all apples in the tree starting at vertex 0 and coming back to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] = [fromi, toi] means that exists an edge connecting the vertices fromi and toi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple, otherwise, it does not have any apple.
 */
public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> mapping = new HashMap<>();

        for (int[] edge : edges) {
            mapping.putIfAbsent(edge[0], new ArrayList<>());
            mapping.putIfAbsent(edge[1], new ArrayList<>());

            mapping.get(edge[0]).add(edge[1]);
            mapping.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(mapping, visited, 0, hasApple);
    }

    private int dfs(Map<Integer, List<Integer>> mapping, Set<Integer> visited, int index, List<Boolean> hasApple) {
        visited.add(index);

        int res = 0;

        for (int neighbor : mapping.get(index)) {
            if (visited.contains(neighbor)) continue;

            res += dfs(mapping, visited, neighbor, hasApple);
        }

        if ((res > 0 || hasApple.get(index)) && index != 0) {
            res += 2;
        }

        return res;
    }
}
