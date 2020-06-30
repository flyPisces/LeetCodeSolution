package KConcatenationMaximumSum;

/**
 * Given an integer array arr and an integer k, modify the array by repeating it k times.
 *
 * For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
 *
 * Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
 *
 * As the answer can be very large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2], k = 3
 * Output: 9
 * Example 2:
 *
 * Input: arr = [1,-2,1], k = 5
 * Output: 2
 * Example 3:
 *
 * Input: arr = [-1,-2], k = 7
 * Output: 0
 */

public class Solution {
    int MOD  = (int) Math.pow(10,9)+7;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;

        for (int num : arr) {
            sum += num;
        }

        long maxSubArraySum = maxSubArraySum(arr), maxLeft = prefixMax(arr), maxRight = postFixMax(arr);

        if (k == 1) return (int) maxSubArraySum;

        if (sum > 0) {
            return (int)Math.max((((k - 2) * sum) % MOD + maxLeft % MOD+ maxRight % MOD) % MOD, maxSubArraySum % MOD);
        } else {
            return (int)Math.max(Math.max(maxSubArraySum % MOD, (maxLeft % MOD + maxRight % MOD) % MOD), 0);
        }
    }

    private long maxSubArraySum(int[] arr) {
        long maxMax = Integer.MIN_VALUE, currMax = 0;

        for (int num : arr) {
            currMax = currMax > 0 ? (currMax + num) % MOD : num;
            maxMax = Math.max(maxMax, currMax);
        }

        return maxMax;
    }

    private long prefixMax(int[] arr) {
        long result = Integer.MIN_VALUE, sum = 0;

        for (int num : arr) {
            sum += num;
            sum %= MOD;
            result = Math.max(result, sum);
        }

        return result;
    }

    private long postFixMax(int[] arr) {
        long result = Integer.MIN_VALUE, sum = 0;

        for (int i = arr.length - 1;i >= 0;-- i) {
            sum += arr[i];
            sum %= MOD;
            result = Math.max(sum, result);
        }

        return result;
    }
}
