package SumofSubsequenceWidths;

import java.util.Arrays;

/**
 *
 Given an array of integers A, consider all non-empty subsequences of A.

 For any sequence S, let the width of S be the difference between the maximum and minimum element of S.

 Return the sum of the widths of all subsequences of A.

 As the answer may be very large, return the answer modulo 10^9 + 7.



 Example 1:

 Input: [2,1,3]
 Output: 6
 Explanation:
 Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
 The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
 The sum of these widths is 6.
 */
public class Solution {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long c = 1, res = 0, MOD = (long)1e9 + 7;

        for (int i = 0;i < A.length;++ i, c = (c << 1) % MOD) {
            res = (res + A[i] * c - A[A.length - 1 - i] * c) % MOD;
        }

        return (int)((res + MOD) % MOD);
    }
}
