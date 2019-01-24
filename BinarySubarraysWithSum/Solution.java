package BinarySubarraysWithSum;

import java.util.*;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?



 Example 1:

 Input: A = [1,0,1,0,1], S = 2
 Output: 4
 Explanation:
 The 4 subarrays are bolded below:
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
 [1,0,1,0,1]
 */
public class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int N = A.length;
        int[] dp = new int[N + 1];

        for (int i = 1;i <= N;++ i) {
            dp[i] = dp[i - 1] + A[i - 1];
        }

        Map<Integer, Integer> mapping = new HashMap<>();

        int result = 0;
        for (int i = 0;i <= N;++ i) {
            result += mapping.getOrDefault(dp[i], 0);
            mapping.put(dp[i] + S, mapping.getOrDefault(dp[i] + S, 0) + 1);
        }

        return result;
    }
}
