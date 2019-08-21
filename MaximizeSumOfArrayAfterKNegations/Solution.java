package MaximizeSumOfArrayAfterKNegations;

/**
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)

 Return the largest possible sum of the array after modifying it in this way.



 Example 1:

 Input: A = [4,2,3], K = 1
 Output: 5
 Explanation: Choose indices (1,) and A becomes [4,-2,3].
 Example 2:

 Input: A = [3,-1,0,2], K = 3
 Output: 6
 Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 Example 3:

 Input: A = [2,-3,-1,5,-4], K = 2
 Output: 13
 Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 */
public class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] dp = new int[201];

        for (int num : A) {
            dp[num + 100] ++;
        }

        for (int i = -100;i <= 100 && K > 0;++ i) {
            if (dp[i + 100] > 0) {
                int k = i < 0 ? Math.min(K, dp[i + 100]) : K % 2;
                dp[-i + 100] += k;
                dp[i + 100] -= k;
                K = i < 0 ? K - k : 0;
            }
        }

        int result = 0;
        for (int i = -100;i <= 100;++ i) result += i * dp[i + 100];

        return result;
    }
}
