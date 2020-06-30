package MaximumNumberofEventsThatCanBeAttended;

import java.util.*;

/**
 *
 Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

 You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

 Return the maximum number of events you can attend.
 */
public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int result = 0, i = 0;

        for (int d = 1;d <= 100000;++ d) {
            while (pq.size() > 0 && pq.peek() < d) {
                pq.poll();
            }

            while (i < events.length && events[i][0] == d) {
                pq.offer(events[i ++][1]);
            }

            if (pq.size() > 0) {
                pq.poll();
                ++ result;
            }
        }
        return result;
    }
}
