package MergeIntervals;

import java.util.Comparator;

/**
 * Created by aoshen on 5/14/16.
 */
public class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}
