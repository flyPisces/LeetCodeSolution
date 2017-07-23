package MaximumAverageSubarrayOne;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k
 * that has the maximum average value. And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].

 * Created by aoshen on 7/18/17.
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = 0.0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0;i < k;++ i) {
            sum += nums[i];
        }
        max = sum;

        for (int i = k;i < nums.length;++ i) {
            int diff = nums[i] - nums[i - k];
            sum += diff;
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
}
