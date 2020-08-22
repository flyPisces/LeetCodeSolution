package MaximumPerformanceofaTeam;

import java.util.*;

/**
 * There are n engineers numbered from 1 to n and two arrays: speed and efficiency, where speed[i] and efficiency[i] represent the speed and efficiency for the i-th engineer respectively. Return the maximum performance of a team composed of at most k engineers, since the answer can be a huge number, return this modulo 10^9 + 7.
 *
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4) and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 * Example 2:
 *
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5 to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 * Example 3:
 *
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 */
public class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long max = 0, sumOfSpeed = 0;

        PriorityQueue<int[]> comboPq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        PriorityQueue<Integer> speedPq = new PriorityQueue<>();

        for (int i = 0;i < n;++ i) {
            comboPq.offer(new int[] {speed[i], efficiency[i]});
        }

        while (!comboPq.isEmpty()) {
            int[] top = comboPq.poll();

            sumOfSpeed += top[0];
            if (speedPq.size() == k) {
                sumOfSpeed -= speedPq.poll();
            }

            max = Math.max(max, top[1] * sumOfSpeed);

            speedPq.offer(top[0]);
        }

        return (int)(max % (long)(1e9 + 7));
    }

    public static void main(String[] args) {
        System.out.println(2e4);
    }
}
