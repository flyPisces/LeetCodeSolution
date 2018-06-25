package GlobalandLocalInversions;

/**
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

 The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

 The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

 Return true if and only if the number of global inversions is equal to the number of local inversions.

 Example 1:

 Input: A = [1,0,2]
 Output: true
 Explanation: There is 1 global inversion, and 1 local inversion.
 Example 2:

 Input: A = [1,2,0]
 Output: false
 Explanation: There are 2 global inversions, and 1 local inversion.
 */
public class Solution {
    public boolean isIdealPermutation(int[] A) {
        int cMax = Integer.MIN_VALUE;

        for (int i = 0;i < A.length - 2;++ i) {
            cMax = Math.max(cMax, A[i]);
            if (cMax > A[i + 2]) {
                return false;
            }
        }

        return true;
    }
}
