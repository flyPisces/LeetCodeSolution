package MergeIntervals;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.

    For example,
    Given [1,3],[2,6],[8,10],[15,18],
    return [1,6],[8,10],[15,18].
 *
 * Created by aoshen on 5/14/16.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new IntervalComparator());

        List<Interval> result = new ArrayList<>();
        int index = 0;
        Interval prev = intervals.get(0);

        for (int i = 1;i < intervals.size();++ i) {
            Interval cur = intervals.get(i);

            if (prev.end >= cur.start) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                result.add(new Interval(prev.start, prev.end));
                prev = cur;
            }
        }

        result.add(prev);

        return result;
    }

}
