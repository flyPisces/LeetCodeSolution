package DegreeofanArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.
 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0, n = nums.length, minSize = n;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer[]> map2 = new HashMap<>();

        for (int i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, map.get(nums[i]));

            if (map2.get(nums[i]) == null) map2.put(nums[i], new Integer[2]);
            Integer[] numRange = map2.get(nums[i]);
            if (numRange[0] == null) numRange[0] = i;
            numRange[1] = i;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != degree) continue;
            Integer[] range = map2.get(entry.getKey());
            minSize = Math.min(minSize, range[1] - range[0] + 1);
        }
        return minSize;
    }
}
