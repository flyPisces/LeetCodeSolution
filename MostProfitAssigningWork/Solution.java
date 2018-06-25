package MostProfitAssigningWork;

import java.awt.*;
import java.util.Arrays;

/**
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.

 Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].

 Every worker can be assigned at most one job, but one job can be completed multiple times.

 For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.

 What is the most profit we can make?

 Example 1:

 Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 Output: 100
 Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 */
public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] pts = new Point[N];

        for (int i = 0;i < N;++ i) {
            pts[i] = new Point(difficulty[i], profit[i]);
        }
        Arrays.sort(pts, (p1, p2) -> p1.x - p2.x);
        Arrays.sort(worker);

        int idx = 0, best = 0, result = 0;
        for (int w : worker) {
            while (idx < N && w >= pts[idx].x) {
                best = Math.max(best, pts[idx].y);
                idx ++;
            }

            result += best;
        }

        return result;
    }
}
