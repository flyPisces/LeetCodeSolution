package ReorderRoutestoMakeAllPathsLeadtotheCityZero;

import java.util.*;

/**
 * There are n cities numbered from 0 to n-1 and n-1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [a, b] represents a road from city a to b.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach the city 0 after reorder.
 */
public class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<String> st = new HashSet<>();
        Map<Integer, Set<Integer>> mapping = new HashMap<>();

        for (int[] connection : connections) {
            st.add(connection[0] + "," + connection[1]);

            mapping.putIfAbsent(connection[0], new HashSet<>());
            mapping.putIfAbsent(connection[1], new HashSet<>());

            mapping.get(connection[0]).add(connection[1]);
            mapping.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> list = new LinkedList<>();
        list.offer(0);
        visited[0] = true;

        int result = 0;

        while (!list.isEmpty()) {
            int c = list.poll();

            for (int next : mapping.getOrDefault(c, new HashSet<>())) {
                if (visited[next]) continue;
                visited[next] = true;

                if (!st.contains(next + "," + c)) result ++;
                list.offer(next);
            }
        }

        return result;
    }
}
