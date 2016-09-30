package PerfectSquares;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 * Created by aoshen on 6/22/16.
 */
public class Solution {
    public int numSquares(int n) {
        int[] arr = new int[n + 1];

        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 1;i * i <= n;++ i) {
            arr[i * i] = 1;
        }

        for (int i = 1;i <= n;++ i) {
            for (int j = 1;j * j + i <=n;++ j) {
                arr[i + j * j] = Math.min(arr[i] + 1, arr[i + j * j]);
            }
        }

        return arr[n];
    }
}
