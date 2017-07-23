package SplitArrayLargestSum;

/**
 * Given an array which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.

 Examples:

 Input:
 nums = [1,2,3,4,5]
 m = 2

 Output:
 9

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [1,2,3] and [4,5],
 where the largest sum among the two subarrays is only 9.

 * Created by aoshen on 10/2/16.
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        return (int) binary_helper(nums, m, sum, max);

    }

    private long binary_helper(int[] nums, int m, long high, long low) {
        while (low < high) {
            long mid = low + (high - low) / 2;

            if (isValid(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean isValid(int[] nums, int m, long sum) {
        long curr = 0;
        int times = 1;

        for (int num: nums) {
            curr += num;

            if (curr > sum) {
                times ++;
                curr = num;
                if (times > m) {
                    return false;
                }
            }
        }

        return true;
    }
}
