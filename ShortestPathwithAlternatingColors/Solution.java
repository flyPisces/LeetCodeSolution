package ShortestPathwithAlternatingColors;

import java.util.*;

/**
 * Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.

 Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.

 Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).



 Example 1:

 Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 Output: [0,1,-1]
 Example 2:

 Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 Output: [0,1,-1]
 Example 3:

 Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 Output: [0,-1,-1]
 Example 4:

 Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 Output: [0,1,2]
 Example 5:

 Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 Output: [0,1,1]
 */
public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<Integer>[] reds = new ArrayList[n], blues = new ArrayList[n];

        for (int[] red_edge : red_edges) {
            if (reds[red_edge[0]] == null) {
                reds[red_edge[0]] = new ArrayList<>();
            }

            reds[red_edge[0]].add(red_edge[1]);
        }

        for (int[] blue_edge : blue_edges) {
            if (blues[blue_edge[0]] == null) {
                blues[blue_edge[0]] = new ArrayList<>();
            }

            blues[blue_edge[0]].add(blue_edge[1]);
        }

        int[] results = new int[n];
        Arrays.fill(results, -1);

        Queue<int[]> queue = new LinkedList<>();
        int moves = 0;
        queue.offer(new int[] {0, 0});
        Set<String> seens = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;++ i) {
                int[] top = queue.poll();

                String key = top[0] + "," + top[1];
                if (seens.contains(key)) continue;
                seens.add(key);

                if (results[top[0]] == -1) {results[top[0]] = moves;}

                if (top[1] == 0 || top[1] == 1) {
                    if (blues[top[0]] != null) {
                        for (int neighbor : blues[top[0]]) {
                            queue.offer(new int[] {neighbor, 2});
                        }
                    }
                }

                if (top[1] == 0 || top[1] == 2) {
                    if (reds[top[0]] != null) {
                        for (int neighbor : reds[top[0]]) {
                            queue.offer(new int[] {neighbor, 1});
                        }
                    }
                }
            }

            ++ moves;
        }

        return results;
    }
}
