package MaxChunksToMakeSortedII;

/**
 * Given an array arr of integers (not necessarily distinct),
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.

 What is the most number of chunks we could have made?

 Example 1:

 Input: arr = [5,4,3,2,1]
 Output: 1
 Explanation:
 Splitting into two or more chunks will not return the required result.
 For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 Example 2:

 Input: arr = [2,1,3,4,4]
 Output: 4
 Explanation:
 We can split into two chunks, such as [2, 1], [3, 4, 4].
 However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int N = arr.length;

        int[] maxLeft = new int[N];
        int[] minRight = new int[N];

        maxLeft[0] = arr[0];
        for (int i = 1;i < N;++ i) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }

        minRight[N - 1] = arr[N - 1];
        for (int i = N - 2;i >= 0;-- i) {
            minRight[i] = Math.min(arr[i], minRight[i + 1]);
        }

        int result = 0;

        for (int i = 0;i < N - 1;++ i) {
            if (maxLeft[i] <= minRight[i + 1]) {
                result ++;
            }
        }

        return result + 1;
    }
}
