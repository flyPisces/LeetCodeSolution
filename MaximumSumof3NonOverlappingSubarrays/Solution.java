package MaximumSumof3NonOverlappingSubarrays;

/***
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

 Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

 Return the result as a list of indices representing the starting position of each interval (0-indexed).
 If there are multiple answers, return the lexicographically smallest one.

 Example:
 Input: [1,2,1,2,6,7,5,1], 2
 Output: [0, 3, 5]
 Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 Note:
 nums.length will be between 1 and 20000.
 nums[i] will be between 1 and 65535.
 k will be between 1 and floor(nums.length / 3).
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1], posLeft = new int[nums.length],
                posRight = new int[nums.length], results = new int[3];

        for (int i = 1;i <= nums.length;++ i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = k, tot = sum[k] - sum[0];i < nums.length;++ i) {
            if (sum[i + 1] - sum[i + 1 - k] > tot) {
                tot = sum[i + 1] - sum[i + 1 - k];
                posLeft[i] = i + 1 - k;
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }

        posRight[nums.length - k] = nums.length - k;
        for (int i = nums.length - k -1, tot = sum[nums.length] - sum[nums.length - k];
                i >= 0;-- i) {
            if (sum[i + k] - sum[i] > tot) {
                tot = sum[i + k] - sum[i];
                posRight[i] = i;
            } else {
                posRight[i] = posRight[i + 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = k;i <= nums.length - 2 * k;++ i) {
            int l = posLeft[i - 1], r = posRight[i + k];
            if (sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r] > max) {
                max = sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r];

                results[0] = l;
                results[1] = i;
                results[2] = r;
            }
        }

        return results;
    }
}
