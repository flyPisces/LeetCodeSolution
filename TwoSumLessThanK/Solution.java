package TwoSumLessThanK;

import java.util.Arrays;
import java.util.Map;

/**
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * Example 2:
 *
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 */
public class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);

        int start = 0, end = A.length - 1;
        int result = -1;

        while (start < end) {
            if (A[start] + A[end] < K) {
                result = Math.max(result, A[start] + A[end]);
                start ++;
            } else {
                end --;
            }
        }

        return result;
    }
}
