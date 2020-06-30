package FrogPositionAfterTSeconds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from the vertex 1. In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected. The frog can not jump back to a visited vertex. In case the frog can jump to several vertices it jumps randomly to one of them with the same probability, otherwise, when the frog can not jump to any unvisited vertex it jumps forever on the same vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] = [fromi, toi] means that exists an edge connecting directly the vertices fromi and toi.
 *
 * Return the probability that after t seconds the frog is on the vertex target.
 *
 *
 */
public class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0;i < n;++ i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0] - 1].add(edge[1] - 1);
            graph[edge[1] - 1].add(edge[0] - 1);
        }

        double[] probs = new double[n];
        probs[0] = 1.0d;

        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty() && t -- > 0) {
            for (int size = queue.size();size > 0;-- size) {
                int top = queue.poll();
                int neighborCnt = 0;
                for (int neighbor : graph[top]) {
                    if (!visited[neighbor]) neighborCnt ++;
                }
                for (int neighbor : graph[top]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        probs[neighbor] = probs[top] / neighborCnt;
                        queue.offer(neighbor);
                    }
                }

                if (neighborCnt > 0) {
                    probs[top] = 0;
                }
            }
        }

        return probs[target - 1];
    }
}
