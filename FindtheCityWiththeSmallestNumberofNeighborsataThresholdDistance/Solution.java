package FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance;

import java.util.*;

/**
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
 *
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
 *
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.
 */
public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new HashMap<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).put(e[1], e[2]);
            g.get(e[1]).put(e[0], e[2]);
        }
        int min = n + 1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            Queue<int[]> q = new PriorityQueue<>((a, b)->(b[1] - a[1]));
            q.add(new int[]{i, distanceThreshold});
            Set<Integer> visited = new HashSet<>();
            int count = 0;
            while (!q.isEmpty()) {
                int[] city = q.poll();
                if (!visited.contains(city[0])) {
                    visited.add(city[0]);
                    count++;
                } else {
                    continue;
                }
                Map<Integer, Integer> m = g.get(city[0]);
                for (int neighbor : m.keySet()) {
                    if (!visited.contains(neighbor) && city[1] >= m.get(neighbor)) {
                        q.add(new int[]{neighbor, city[1] - m.get(neighbor)});
                    }
                }
            }
            if (count - 1 <= min) {
                min = count - 1;
                res = i;
            }
        }
        return res;
    }
}
