package LCSWithAbsoluteDiffLessThanorEqualtoLimit;

import AllNodesDistanceKinBinaryTree.TreeNode;

import java.util.*;

/**
 * Given an array of integers nums and an integer limit, return the size of the longest continuous subarray such that the absolute difference between any two elements is less than or equal to limit.
 *
 * In case there is no subarray satisfying the given condition return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 *
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 *
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 */
public class Solution {
    public int longestSubarray(int[] A, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < A.length; j++) {
            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
        }
        return j - i;
    }

    public int longestSubarray1(int[] nums, int limit) {
        int left = 0, right = 0, maxLen = 0;
        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> (nums[a] == nums[b]) ? a - b : nums[a] - nums[b]);
        treeSet.add(0);
        maxLen = 1;

        for (right = 1;right < nums.length;++ right) {
            treeSet.add(right);

            while (nums[treeSet.last()] - nums[treeSet.first()] > limit) {
                treeSet.remove(left ++);
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public int longestSubarray2(int[] nums, int limit) {
        int left = 0, right = 0, maxLen = 0;

        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();

        for (right = 0;right < nums.length;++ right) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.add(nums[right]);

            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            minQueue.add(nums[right]);

            while (maxQueue.peekFirst() - minQueue.peekFirst() > limit) {
                if (maxQueue.peekFirst() == nums[left]) maxQueue.pollFirst();
                if (minQueue.peekFirst() == nums[left]) minQueue.pollFirst();

                left ++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestSubarray(new int[] {4,2,2,2,4,4,2,2}, 0));
    }
}
