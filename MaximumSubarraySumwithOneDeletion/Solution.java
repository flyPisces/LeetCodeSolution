package MaximumSubarraySumwithOneDeletion;

/**
 *
 Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

 Note that the subarray needs to be non-empty after deleting one element.



 Example 1:

 Input: arr = [1,-2,0,3]
 Output: 4
 Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 Example 2:

 Input: arr = [1,-2,-2,3]
 Output: 3
 Explanation: We just choose [3] and it's the maximum sum.
 Example 3:

 Input: arr = [-1,-1,-1,-1]
 Output: -1
 Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
 */

public class Solution {
    public int maximumSum(int[] arr) {
        int result = Integer.MIN_VALUE, N = arr.length;

        int[] maxStart = new int[N], maxEnd = new int[N];

        maxEnd[0] = arr[0];
        result = maxEnd[0];
        for (int i = 1;i < N;++ i) {
            maxEnd[i] = Math.max(arr[i], arr[i] + maxEnd[i - 1]);
            result = Math.max(result, maxEnd[i]);
        }

        maxStart[N - 1] = arr[N - 1];
        result = Math.max(result, maxStart[N - 1]);
        for (int i = N - 2;i >= 0;-- i) {
            maxStart[i] = Math.max(arr[i], arr[i] + maxStart[i + 1]);
            result = Math.max(result, maxStart[i]);
        }

        for (int i = 1;i < N - 1;++ i) {
            result = Math.max(result, maxEnd[i - 1] + maxStart[i + 1]);
        }

        return result;
    }
}
