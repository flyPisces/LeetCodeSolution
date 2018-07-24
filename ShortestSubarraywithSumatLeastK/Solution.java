package ShortestSubarraywithSumatLeastK;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Return the length of the shortest, non-empty,
 * contiguous subarray of A with sum at least K.

 If there is no non-empty subarray with sum at least K, return -1.



 Example 1:

 Input: A = [1], K = 1
 Output: 1
 Example 2:

 Input: A = [1,2], K = 4
 Output: -1
 Example 3:

 Input: A = [2,-1,2], K = 3
 Output: 3
 */
public class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N + 1];

        for (int i = 0;i < N;++ i) {
            dp[i + 1] = dp[i] + A[i];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int res = N + 1;
        for (int i = 0;i <= N;++ i) {
            while (queue.size() > 0 && dp[i] - dp[queue.getFirst()] >= K) {
                res = Math.min(res, i - queue.pollFirst());
            }

            while (queue.size() > 0 && dp[i] <= dp[queue.getLast()]) {
                queue.pollLast();
            }

            queue.addLast(i);
        }

        return res == N + 1 ? -1 : res;
    }
}
