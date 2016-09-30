package InsertInterval;

import java.util.*;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:
    Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    Example 2:
    Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Created by aoshen on 5/14/16.
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        if (newInterval == null || intervals == null) {
            return intervals;
        }

        int insertionIndex = 0;

        for (Interval interval : intervals) {
            if (newInterval.start > interval.end) {
                result.add(interval);
                insertionIndex ++;
            } else if (newInterval.end < interval.start) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }

        result.add(insertionIndex, newInterval);
        return result;
    }
}
