package PartitionArrayintoDisjointIntervals;

/**
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:

 Every element in left is less than or equal to every element in right.
 left and right are non-empty.
 left has the smallest possible size.
 Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.



 Example 1:

 Input: [5,0,3,8,6]
 Output: 3
 Explanation: left = [5,0,3], right = [8,6]
 Example 2:

 Input: [1,1,1,0,6,12]
 Output: 4
 Explanation: left = [1,1,1,0], right = [6,12]
 */
public class Solution {
    public int partitionDisjoint(int[] A) {
        int N = A.length;

        int[] maxLeft = new int[N], minRight = new int[N];

        maxLeft[0] = A[0];
        for (int i = 1;i < N;++ i) {
            maxLeft[i] = Math.max(A[i], maxLeft[i - 1]);
        }

        minRight[N - 1] = A[N - 1];
        for (int i = N - 2;i >= 0;-- i) {
            minRight[i] = Math.min(minRight[i + 1], A[i]);
        }

        for (int i = 0;i < N - 1;++ i) {
            if (maxLeft[i] <= minRight[i + 1]) {
                return i + 1;
            }
        }

        return -1;
    }
}
