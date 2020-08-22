package SteppingNumbers;

import java.util.*;

/**
 * A Stepping Number is an integer such that all of its adjacent digits have an absolute difference of exactly 1. For example, 321 is a Stepping Number while 421 is not.
 *
 * Given two integers low and high, find and return a sorted list of all the Stepping Numbers in the range [low, high] inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 0, high = 21
 * Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
 */
public class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> results = new ArrayList<>();

        if (low > high) return results;

        Queue<Long> queue = new LinkedList<>();
        for (long i = 1;i <= 9;++ i) {
            queue.offer(i);
        }

        if (low == 0) results.add(0);

        while (!queue.isEmpty()) {
            long top = queue.poll();

            if (top < high) {
                long last = top % 10;
                if (last > 0) queue.offer(10 * top + last - 1);
                if (last < 9) queue.offer(10 * top + last + 1);
            }

            if (top >= low && top <= high) {
                results.add((int)top);
            }
        }

        return results;
    }
}
