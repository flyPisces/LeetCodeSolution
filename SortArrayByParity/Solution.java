package SortArrayByParity;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [3,1,2,4]
 Output: [2,4,3,1]
 The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;

        while (left < right) {
            while (left < right && A[left] % 2 == 0) {
                left ++;
            }

            while (left < right && A[right] % 2 == 1) {
                right --;
            }

            if (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }

            left ++;
            right --;
        }

        return A;
    }
}
