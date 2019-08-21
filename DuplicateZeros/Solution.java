package DuplicateZeros;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

 Note that elements beyond the length of the original array are not written.

 Do the above modifications to the input array in place, do not return anything from your function.



 Example 1:

 Input: [1,0,2,3,0,4,5,0]
 Output: null
 Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 Example 2:

 Input: [1,2,3]
 Output: null
 Explanation: After calling your function, the input array is modified to: [1,2,3]
 */
public class Solution {
    public void duplicateZeros(int[] arr) {
        int j = 0, N = arr.length;

        for (int i = 0;i < arr.length;++ i, ++ j) {
            if (arr[i] == 0) ++ j;
        }

        for (int i = N - 1;i >= 0;-- i) {
            if (-- j < N) arr[j] = arr[i];
            if (arr[i] == 0 && --j < N) arr[j] = 0;
        }
    }
}
