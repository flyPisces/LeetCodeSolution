package MaximumLengthofRepeatedSubarray;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

 Example 1:
 Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].
 Note:
 1 <= len(A), len(B) <= 1000
 0 <= A[i], B[i] < 100
 */
public class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }

        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;

        for (int i = 0;i <= A.length;++ i) {
            for (int j = 0;j <= B.length;++ j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
