package RangeModule;

import java.util.*;

/**
 * A Range Module is a module that tracks ranges of numbers.
 * Your task is to design and implement the following interfaces in an efficient manner.

 addRange(int left, int right) Adds the half-open interval [left, right),
 tracking every real number in that interval.
 Adding an interval that partially overlaps with currently tracked numbers
 should add any numbers in the interval [left, right) that are not already tracked.
 queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right)
 is currently being tracked.
 removeRange(int left, int right) Stops tracking every real number currently being tracked
 in the interval [left, right).
 Example 1:
 addRange(10, 20): null
 removeRange(14, 16): null
 queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 Note:

 A half open interval [left, right) denotes all real numbers left <= x < right.
 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
 The total number of calls to addRange in a single test case is at most 1000.
 The total number of calls to queryRange in a single test case is at most 5000.
 The total number of calls to removeRange in a single test case is at most 1000.
 */
public class Solution {
    TreeSet<Interval> ranges = null;

    public Solution() {
        ranges = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> iter = ranges.tailSet(new Interval(0, left)).iterator();
        while (iter.hasNext()) {
            Interval it = iter.next();
            if (right < it.left) break;
            left = Math.min(left, it.left);
            right = Math.max(right, it.right);
            iter.remove();
        }

        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval it = ranges.higher(new Interval(0, left));
        return it != null && it.left <= left && it.right >= right;

    }

    public void removeRange(int left, int right) {
        Iterator<Interval> iter = ranges.tailSet(new Interval(0, left)).iterator();
        List<Interval> todo = new ArrayList<>();
        while (iter.hasNext()) {
            Interval iv = iter.next();
            if (right < iv.left) break;
            if (iv.left < left) todo.add(new Interval(iv.left, left));
            if (right < iv.right) todo.add(new Interval(right, iv.right));
            iter.remove();
        }

        for (Interval iv : todo) {
            ranges.add(iv);
        }
    }
}
