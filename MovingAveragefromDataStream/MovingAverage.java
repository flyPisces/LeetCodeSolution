package MovingAveragefromDataStream;

import java.util.*;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    For example,
    MovingAverage m = new MovingAverage(3);
    m.next(1) = 1
    m.next(10) = (1 + 10) / 2
    m.next(3) = (1 + 10 + 3) / 3
    m.next(5) = (10 + 3 + 5) / 3

 * Created by aoshen on 7/19/16.
 */
public class MovingAverage {

    Queue<Integer> list;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (list.size() == size) {
            list.poll();
        }

        list.offer(val);

        double sum = 0;
        for (Integer num : list) {
            sum += num;
        }

        return sum / list.size();
    }
}
