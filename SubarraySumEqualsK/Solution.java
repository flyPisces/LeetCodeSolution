package SubarraySumEqualsK;

import java.util.*;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 * Created by aoshen on 5/1/17.
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int i = 0;i < nums.length;++ i) {
            sum += nums[i];

            if (sumMap.containsKey(sum - k)) {
                result += sumMap.get(sum - k);
            }

            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
