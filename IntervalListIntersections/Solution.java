package IntervalListIntersections;


import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

 Return the intersection of these two interval lists.

 (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */
public class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int low = Math.max(A[i].start, B[j].start);
            int high = Math.min(A[i].end, B[j].end);

            if (low <= high) {
                res.add(new Interval(low, high));
            }

            if (A[i].end < B[j].end) {
                ++ i;
            } else
                ++ j;
        }

        return res.toArray(new Interval[res.size()]);
    }
}
