package EmployeeFreeTime;

import java.util.*;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.

 Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

 Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

 Example 1:
 Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 Output: [[3,4]]
 Explanation:
 There are a total of three employees, and all common
 free time intervals would be [-inf, 1], [3, 4], [10, inf].
 We discard any intervals that contain inf as they aren't finite.
 Example 2:
 Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 Output: [[5,6],[7,9]]
 */
public class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        List<Interval> results = new ArrayList<>();

        for (List<Interval> list : schedule) {
            pq.addAll(list);
        }

        Interval curr = pq.poll();
        while (!pq.isEmpty()) {
            if (curr.end < pq.peek().start) {
                results.add(new Interval(curr.end, pq.peek().start));
                curr = pq.poll();
            } else {
                curr = curr.end < pq.peek().end ? pq.peek() : curr;
                pq.poll();
            }
        }

        return results;
    }
}
