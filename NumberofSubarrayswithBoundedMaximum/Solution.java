package NumberofSubarrayswithBoundedMaximum;

/**
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).

 Return the number of (contiguous, non-empty) subarrays such that
 the value of the maximum array element in that subarray is at least L and at most R.

 Example :
 Input:
 A = [2, 1, 4, 3]
 L = 2
 R = 3
 Output: 3
 Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 */
public class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0, count = 0, i = 0, j = 0;

        for (int x : A) {

            if (x >= L && x <= R) {
                res += i - j + 1;
                count = i - j + 1;
            } else if (x < L) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }

            i ++;
        }

        return res;
    }
}
