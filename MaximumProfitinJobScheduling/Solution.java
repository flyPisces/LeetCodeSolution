package MaximumProfitinJobScheduling;

import java.util.*;

/**
 *
 We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

 You're given the startTime , endTime and profit arrays, you need to output the maximum profit you can take such that there are no 2 jobs in the subset with overlapping time range.

 If you choose a job that ends at time X you will be able to start another job that starts at time X.


 Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 Output: 120
 Explanation: The subset chosen is the first and fourth job.
 Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.

 Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 Output: 150
 Explanation: The subset chosen is the first, fourth and fifth job.
 Profit obtained 150 = 20 + 70 + 60.
 */
public class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;

        int[][] items = new int[N][3];
        for (int i = 0;i < N;++ i) {
            items[i][0] = startTime[i];
            items[i][1] = endTime[i];
            items[i][2] = profit[i];
        }
        Arrays.sort(items, (a, b) -> (a[1] - b[1]));

        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();

        dpEndTime.add(0);
        dpProfit.add(0);

        for (int[] item : items) {
            int newStart = item[0] + 1;
            int idx = getIndex(dpEndTime, newStart);

            int newTotal = dpProfit.get(idx) + item[2];
            if (newTotal > dpProfit.get(dpProfit.size() - 1)) {
                dpEndTime.add(item[1]);
                dpProfit.add(newTotal);
            }
        }

        return dpProfit.get(dpProfit.size() - 1);
    }

    private int getIndex(List<Integer> dpEndTime, int newStart) {
        int size = dpEndTime.size();

        if (newStart > dpEndTime.get(size - 1)) return size - 1;

        int left = 0, right = size - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (dpEndTime.get(mid) < newStart && dpEndTime.get(mid + 1) >= newStart) return mid;
            else if (dpEndTime.get(mid) < newStart) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
