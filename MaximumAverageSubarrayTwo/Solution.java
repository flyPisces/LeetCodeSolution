package MaximumAverageSubarrayTwo;

/**
 * Given an array consisting of n integers, find the contiguous subarray
 * whose length is greater than or equal to k that has the maximum average value.
 *
 * And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation:
 when length is 5, maximum average value is 10.8,
 when length is 6, maximum average value is 9.16667.
 Thus return 12.75.
 Note:
 1 <= k <= n <= 10,000.
 Elements of the given array will be in range [-10,000, 10,000].
 The answer with the calculation error less than 10-5 will be accepted.

 * Created by aoshen on 7/18/17.
 */
public class Solution {

    private boolean check(int[] nums, int k, double x) {
        int len = nums.length;
        double[] arr = new double[len];
        for (int i = 0;i < len;++ i) {
            arr[i] = nums[i] - x;
        }
        double now = 0, last = 0;
        for (int i = 0;i < k;++ i) {
            now += arr[i];
        }

        if (now >= 0) return true;
        for (int i = k;i < len;++ i) {
            now += arr[i];
            last += arr[i - k];

            if (last < 0) {
                now -= last;
                last = 0;
            }

            if (now >= 0) return true;
        }

        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        while (max - min >= 0.000004) {
            double mid = (max + min) / 2;
            if (check(nums, k, mid)) min = mid; else max = mid;
        }

        return max;
    }
}
