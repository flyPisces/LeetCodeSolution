package CheapestFlightsWithinKStops;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.*;

/**
 *
 There are n cities connected by m flights.
 Each fight starts from city u and arrives at v with a price w.

 Now given all the cities and fights,
 together with starting city src and the destination dst,
 your task is to find the cheapest price from src to dst with up to k stops.

 If there is no such route, output -1.

 Example 1:
 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 1
 Output: 200
 Explanation:
 The graph looks like this:


 The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 Example 2:
 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 0
 Output: 500
 Explanation:
 The graph looks like this:


 The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 */
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];

        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[0] - arr2[0]);
        pq.add(new int[] {0, 0, src});

        Map<int[], Integer> mapping = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int cost = top[0], k = top[1], place = top[2];
            if (k > K + 1 || cost > mapping.getOrDefault(new int[]{k, place}, Integer.MAX_VALUE)) {
                continue;
            }

            if (place == dst) return cost;
            for (int neighor = 0;neighor < n;++ neighor) {
                if (graph[place][neighor] > 0) {
                    int newCost = cost + graph[place][neighor];
                    if (newCost < mapping.getOrDefault(new int[] {k + 1, neighor}, Integer.MAX_VALUE)) {
                        mapping.put(new int[] {k + 1, neighor}, newCost);
                        pq.add(new int[] {newCost, k + 1, neighor});
                    }
                }
            }
        }


        return -1;
    }
}
