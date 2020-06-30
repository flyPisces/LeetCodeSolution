package OptimizeWaterDistributioninaVillage;

import java.util.*;

/**
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 *
 * For each house i, we can either build a well inside it directly with cost wells[i], or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[i] = [house1, house2, cost] represents the cost to connect house1 and house2 together using a pipe. Connections are bidirectional.
 *
 * Find the minimum total cost to supply water to all houses.
 */

public class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        int result = 0;
        int[] dp = new int[n + 1];
        for (int i = 0;i <= n;++ i) dp[i] = i;

        for (int[] pipe : pipes) {
            pq.offer(pipe);
        }

        for (int i = 0;i < n;++ i) {
            pq.offer(new int[] {0, i + 1, wells[i]});
        }

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();

            int p1 = df(dp, arr[0]), p2 = df(dp, arr[1]);

            if (p1 != p2) {
                result += arr[2];
                dp[p1] = p2;
            }
        }

        return result;
    }

    private int df(int[] dp, int num) {
        if (dp[num] == num) return dp[num];
        else {
            dp[num] = df(dp, dp[num]);

            return dp[num];
        }
    }
}
