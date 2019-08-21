package PartitionArrayforMaximumSum;

/**
 * Given an integer array A, you partition the array into (contiguous) subarrays of length at most K.  After partitioning, each subarray has their values changed to become the maximum value of that subarray.

 Return the largest sum of the given array after partitioning.



 Example 1:

 Input: A = [1,15,7,9,2,5,10], K = 3
 Output: 84
 Explanation: A becomes [15,15,15,9,10,10,10]
 */
public class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N];

        for (int i = 0;i < N;++ i) {
            int currMax = 0;
            for (int k = 1;k < K && i - k + 1 >= 0;++ k) {
                currMax = Math.max(currMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i - k + 1 >= 0 ? dp[i - k + 1] : 0) + currMax * k);
            }
        }

        return dp[N - 1];
    }
}
