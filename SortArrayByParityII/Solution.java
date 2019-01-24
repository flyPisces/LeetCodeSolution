package SortArrayByParityII;

/**
 *
 Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

 Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [4,2,5,7]
 Output: [4,5,2,7]
 Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;

        for (int i = 0;i < A.length;i = i + 2) {
            if (A[i] % 2 != 0) {
                while (j < A.length && A[j] % 2 == 1) {
                    j = j + 2;
                }

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;
    }
}
