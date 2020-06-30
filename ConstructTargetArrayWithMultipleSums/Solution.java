package ConstructTargetArrayWithMultipleSums;

import java.util.*;

/**
 * Given an array of integers target. From a starting array, A consisting of all 1's, you may perform the following procedure :
 *
 * let x be the sum of all elements currently in your array.
 * choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
 * You may repeat this procedure as many times as needed.
 * Return True if it is possible to construct the target array from A otherwise return False.
 *
 *
 *
 * Example 1:
 *
 * Input: target = [9,3,5]
 * Output: true
 * Explanation: Start with [1, 1, 1]
 * [1, 1, 1], sum = 3 choose index 1
 * [1, 3, 1], sum = 5 choose index 2
 * [1, 3, 5], sum = 9 choose index 0
 * [9, 3, 5] Done
 * Example 2:
 *
 * Input: target = [1,1,1,2]
 * Output: false
 * Explanation: Impossible to create target array from [1,1,1,1].
 * Example 3:
 *
 * Input: target = [8,5]
 * Output: true
 */
public class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        long sum = 0;
        for (int num : target) {
            sum += num;
            pq.offer(num);
        }

        while (true) {
            int top = pq.poll();
            sum -= top;

            if (top == 1 || sum == 1) return true;
            if (top < sum || sum == 0 || top % sum == 0) return false;
            top = top % (int)sum;
            sum += top;
            pq.offer(top);
        }

    }
}
