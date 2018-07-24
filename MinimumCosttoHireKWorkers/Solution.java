package MinimumCosttoHireKWorkers;

import java.util.*;

/**
 *
 There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

 Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers,
 we must pay them according to the following rules:

 Every worker in the paid group should be paid in the ratio of their quality
 compared to other workers in the paid group.
 Every worker in the paid group must be paid at least their minimum wage expectation.
 Return the least amount of money needed to form a paid group satisfying the above conditions.



 Example 1:

 Input: quality = [10,20,5], wage = [70,50,30], K = 2
 Output: 105.00000
 Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
 Example 2:

 Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
 Output: 30.66667
 Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately.
 */
public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        double[][] dp = new double[N][2];

        for (int i = 0;i < N;++ i) {
            dp[i][0] = ((double) wage[i]) / quality[i];
            dp[i][1] = (double) quality[i];
        }

        Arrays.sort(dp, (a, b) -> Double.compare(a[0], b[0]));
        double result = Double.MAX_VALUE, sum_quality = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for (double[] arr : dp) {
            sum_quality += arr[1];
            pq.offer(-arr[1]);
            if (pq.size() > K) {
                sum_quality += pq.poll();
            }
            if (pq.size() == K) {
                result = Math.min(result, arr[0] * sum_quality);
            }
        }

        return result;

    }
}
