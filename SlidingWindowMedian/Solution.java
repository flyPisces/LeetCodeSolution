package SlidingWindowMedian;

import java.util.*;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Median
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 Therefore, return the median sliding window as [1,-1,-1,3,5,6].

 * Created by aoshen on 1/12/17.
 */
public class Solution {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];

        double[] results = new double[n];

        for (int i = 0;i <= nums.length;++ i) {
            if (i >= k) {
                results[i - k] = getMedian();
                remove(nums[i - k]);
            }

            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return results;
    }

    private void add(int num) {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }

        double median = getMedian();

        if (minHeap.size() == maxHeap.size()) {
            if (num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (num <= median) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
            }
        }
    }

    private void remove(int num) {
        double median = getMedian();

        if (minHeap.size() == maxHeap.size()) {
            if (num <= maxHeap.peek()) {
                maxHeap.add(minHeap.poll());
                maxHeap.remove(num);
            } else {
                minHeap.remove(num);
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (num <= median) {
                maxHeap.remove(num);
            } else {
                minHeap.add(maxHeap.poll());
                minHeap.remove(num);
            }
        }
    }

    private double getMedian() {
        if (minHeap.isEmpty() && !maxHeap.isEmpty()) return maxHeap.peek();
        if (!minHeap.isEmpty() && maxHeap.isEmpty()) return minHeap.peek();

        if (minHeap.size() == maxHeap.size()) {
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2.0;
        } else {
            return (double)maxHeap.peek();
        }
    }
}
