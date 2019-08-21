package LongestWellPerformingInterval;

import java.util.*;

/**
 * We are given hours, a list of the number of hours worked per day for a given employee.

 A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

 A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

 Return the length of the longest well-performing interval.



 Example 1:

 Input: hours = [9,9,6,0,6,6,9]
 Output: 3
 Explanation: The longest well-performing interval is [9,9,6].
 */
public class Solution {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int result = 0, sum = 0;

        for (int i = 0;i < hours.length;++ i) {
            sum += hours[i] > 8 ? 1 : -1;

            if (sum > 0) {
                result = i + 1;
            } else {
                mapping.putIfAbsent(sum, i);

                if (mapping.containsKey(sum - 1)) {
                    result = Math.max(result, i - mapping.get(sum - 1));
                }
            }
        }

        return result;
    }
}
