package LongestHarmoniousSubsequence;

import java.util.*;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence
 among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 Note: The length of the input array will not exceed 20,000.

 * Created by aoshen on 5/24/17.
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> numTimeMapping = new HashMap<>();

        for (int num : nums) {
            numTimeMapping.put(num, numTimeMapping.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (Integer key : numTimeMapping.keySet()) {
            if (numTimeMapping.containsKey(key + 1)) {
                result = Math.max(result, numTimeMapping.get(key + 1) + numTimeMapping.get(key));
            }
        }

        return result;
    }
}
