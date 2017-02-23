package ContiguousArray;

import java.util.*;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 Note: The length of the given binary array will not exceed 50,000.

 * Created by aoshen on 2/20/17.
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        for (int i = 0;i < nums.length;++ i) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int max = 0;
        int sum = 0;
        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0, -1);

        for (int i = 0;i < nums.length;++ i) {
            sum += nums[i];

            if (mapping.containsKey(sum)) {
                max = Math.max(max, i - mapping.get(sum));
            } else {
                mapping.put(sum, i);
            }
        }

        return max;
    }
}
