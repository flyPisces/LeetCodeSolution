package ValidMountainArray;

/**
 *
 Given an array A of integers, return true if and only if it is a valid mountain array.

 Recall that A is a mountain array if and only if:

 A.length >= 3
 There exists some i with 0 < i < A.length - 1 such that:
 A[0] < A[1] < ... A[i-1] < A[i]
 A[i] > A[i+1] > ... > A[B.length - 1]


 Example 1:

 Input: [2,1]
 Output: false
 Example 2:

 Input: [3,5,5]
 Output: false
 Example 3:

 Input: [0,3,2,1]
 Output: true
 */
public class Solution {
    public boolean validMountainArray(int[] A) {
        int idx = 0;

        while (idx + 1 < A.length && A[idx] < A[idx + 1]) {
            idx ++;
        }

        if (idx == 0 || idx == A.length - 1) return false;

        while (idx + 1 < A.length && A[idx] > A[idx + 1]) {
            idx ++;
        }

        return idx == A.length - 1;
    }
}
