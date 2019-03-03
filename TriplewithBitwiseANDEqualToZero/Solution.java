package TriplewithBitwiseANDEqualToZero;

/**
 * Given an array of integers A, find the number of triples of indices (i, j, k) such that:

 0 <= i < A.length
 0 <= j < A.length
 0 <= k < A.length
 A[i] & A[j] & A[k] == 0, where & represents the bitwise-AND operator.


 Example 1:

 Input: [2,1,3]
 Output: 12
 Explanation: We could choose the following i, j, k triples:
 (i=0, j=0, k=1) : 2 & 2 & 1
 (i=0, j=1, k=0) : 2 & 1 & 2
 (i=0, j=1, k=1) : 2 & 1 & 1
 (i=0, j=1, k=2) : 2 & 1 & 3
 (i=0, j=2, k=1) : 2 & 3 & 1
 (i=1, j=0, k=0) : 1 & 2 & 2
 (i=1, j=0, k=1) : 1 & 2 & 1
 (i=1, j=0, k=2) : 1 & 2 & 3
 (i=1, j=1, k=0) : 1 & 1 & 2
 (i=1, j=2, k=0) : 1 & 3 & 2
 (i=2, j=0, k=1) : 3 & 2 & 1
 (i=2, j=1, k=0) : 3 & 1 & 2
 */
public class Solution {
    public int countTriplets(int[] A) {
        int N = 1 << 16;
        int[] dp = new int[N];
        dp[N - 1] = 1;

        for (int i = 0;i < 3;++ i) {
            int[] temp = new int[N];
            for (int k = 0;k < N;++ k) {
                for (int num : A) {
                    temp[k & num] += dp[k];
                }
            }
            dp = temp;
        }

        return dp[0];
    }
}
