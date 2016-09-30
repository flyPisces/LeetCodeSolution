package FindMedianfromDataStream;

import java.util.PriorityQueue;
import java.util.*;
/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 For example:

 add(1)
 add(2)
 findMedian() -> 1.5
 add(3)
 findMedian() -> 2

 * Created by aoshen on 6/4/16.
 */
public class MedianFinder {

    PriorityQueue<Integer> minPQ;
    PriorityQueue<Integer> maxPQ;

    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
            if (maxPQ.size() > minPQ.size()) {
                minPQ.offer(maxPQ.poll());
            }
            maxPQ.offer(num);
        } else if (minPQ.isEmpty() || num >= minPQ.peek()) {
            if (minPQ.size() > maxPQ.size()) {
                maxPQ.offer(minPQ.poll());
            }
            minPQ.offer(num);
        } else {
            if (maxPQ.size() <= minPQ.size()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxPQ.isEmpty() && minPQ.isEmpty()) {
            return 0;
        } else if (maxPQ.size() == minPQ.size()) {
            return (maxPQ.peek() + minPQ.peek()) / 2.0;
        } else if (maxPQ.size() > minPQ.size()) {
            return maxPQ.peek();
        } else {
            return minPQ.peek();
        }
    }
}
