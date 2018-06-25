package SplitArrayWithSameAverage;

import java.util.Arrays;

/**
 *
 In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)

 Return true if and only if after such a move, it is possible that the average value of B is equal to the average value of C, and B and C are both non-empty.

 Example :
 Input:
 [1,2,3,4,5,6,7,8]
 Output: true
 Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 Note:
 */
public class Solution {
    private boolean helper(int[] A, int leftSum, int leftNum, int startIdx) {
        if (leftNum == 0) return leftSum == 0;

        for (int j = startIdx;j < A.length - leftNum + 1;++ j) {
            if (j > startIdx && A[j] == A[j - 1]) continue;
            if (helper(A, leftSum - A[j], leftNum - 1, j + 1)) {
                return true;
            }
        }

        return false;
    }

    public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) return false;
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        Arrays.sort(A);

        for (int i = 1;i <= A.length / 2;++ i) {
            if ((sum * i) % A.length == 0) {
                if (helper(A, (sum * i) / A.length, i, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
