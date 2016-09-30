package DataStreamasDisjointIntervals;

import java.util.*;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]
 Follow up:
 What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

 * Created by aoshen on 6/18/16.
 */
public class SummaryRanges {

    private TreeSet<Interval> intervalSet;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervalSet = new TreeSet<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

    }

    public void addNum(int val) {
        Interval interval = new Interval(val, val);

        Interval left = intervalSet.floor(interval);
        if (left != null) {
            if (left.end >= val) {
                return;
            } else if (left.end + 1 == val) {
                interval.start = left.start;
                intervalSet.remove(left);
            }
        }

        Interval right = intervalSet.higher(interval);
        if (right != null && right.start == val + 1){
            interval.end = right.end;
            intervalSet.remove(right);
        }

        intervalSet.add(interval);
    }

    public List<Interval> getIntervals() {
        return  Arrays.asList(intervalSet.toArray(new Interval[0]));
    }
}
