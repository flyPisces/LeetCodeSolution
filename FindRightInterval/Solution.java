package FindRightInterval;

import java.util.*;

/**
 * Given a set of intervals, for each of the interval i,
 * check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i,
 * which can be called that j is on the "right" of i.

 For any interval i, you need to store the minimum interval j's index,
 which means that the interval j has the minimum start point to build the "right" relationship for interval i.
 If the interval j doesn't exist, store -1 for the interval i.
 Finally, you need output the stored value of each interval as an array.

 Note:
 You may assume the interval's end point is always bigger than its start point.
 You may assume none of these intervals have the same start point.
 Example 1:
 Input: [ [1,2] ]

 Output: [-1]

 Explanation: There is only one interval in the collection, so it outputs -1.
 Example 2:
 Input: [ [3,4], [2,3], [1,2] ]

 Output: [-1, 0, 1]

 Explanation: There is no satisfied "right" interval for [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point;
 For [1,2], the interval [2,3] has minimum-"right" start point.
 Example 3:
 Input: [ [1,4], [2,3], [3,4] ]

 Output: [-1, 2, -1]

 Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 For [2,3], the interval [3,4] has minimum-"right" start point.

 * Created by aoshen on 11/9/16.
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] results = new int[intervals.length];

        for (int i = 0;i < intervals.length;++ i) map.put(intervals[i].start, i);
        for (int i = 0;i < intervals.length;++ i) {
            Integer key = map.ceilingKey(intervals[i].end);
            results[i] = key == null ? -1 : map.get(key);
        }

        return results;
    }
}
