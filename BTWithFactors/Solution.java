package BTWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 Given an array of unique integers, each integer is strictly greater than 1.

 We make a binary tree using these integers and each number may be used for any number of times.

 Each non-leaf node's value should be equal to the product of the values of it's children.

 How many binary trees can we make?  Return the answer modulo 10 ** 9 + 7.

 Example 1:

 Input: A = [2, 4]
 Output: 3
 Explanation: We can make these trees: [2], [4], [4, 2, 2]
 Example 2:

 Input: A = [2, 4, 5, 10]
 Output: 7
 Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 */
public class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        Arrays.sort(A);
        int N = A.length;
        long[] dp = new long[N];

        Arrays.fill(dp, 1);

        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0;i < N;++ i) {
            mapping.put(A[i], i);
        }

        for (int i = 0;i < N;++ i) {
            for (int j = 0;j < i;++ j) {
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];

                    if (mapping.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[mapping.get(right)]) % MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (long num : dp) {
            ans += num;
        }

        return (int)(ans % MOD);
    }
}
