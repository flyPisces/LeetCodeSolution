package DivideArrayinSetsofKConsecutiveNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * Example 2:
 *
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 * Example 3:
 *
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * Example 4:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 */
public class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int N = nums.length;
        if (N % k != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> countMapping = new HashMap<>();
        for (int num : nums) {
            countMapping.put(num, countMapping.getOrDefault(num, 0) + 1);
        }

        for (int key : countMapping.keySet()) {
            pq.offer(key);
        }

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (countMapping.get(curr) == 0) continue;

            int cnt = countMapping.get(curr);
            for (int i = 0;i < k;++ i) {
                if (!countMapping.containsKey(curr + i) || countMapping.get(curr + i) < cnt) return false;
                countMapping.put(curr + i, countMapping.get(curr + i) - cnt);
            }
            N = N - cnt * k;
        }

        return N == 0;
    }
}
