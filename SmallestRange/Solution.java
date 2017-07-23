package SmallestRange;

import java.util.*;

/**
 * You have k lists of sorted integers in ascending order.
 * Find the smallest range that includes at least one number from each of the k lists.

 We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

 Example 1:
 Input:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 Output: [20,24]
 Explanation:
 List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 List 2: [0, 9, 12, 20], 20 is in range [20,24].
 List 3: [5, 18, 22, 30], 22 is in range [20,24].
 Note:
 The given list may contain duplicates, so ascending order means >= here.
 1 <= k <= 3500
 -105 <= value of elements <= 105.
 For Java users, please note that the input type has been changed to List<List<Integer>>.
 And after you reset the code template, you'll see this point.


 * Created by aoshen on 7/7/17.
 */
public class Solution {

    class Element {
        int row;
        int col;
        int element;

        public Element(int row, int col, int element) {
            this.row = row;
            this.col = col;
            this.element = element;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e1.element - e2.element);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0;i < nums.size();++ i) {
            Element ele = new Element(i, 0, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
            pq.add(ele);
        }

        int range = Integer.MAX_VALUE, start = -1, end = -1;
        while (pq.size() == nums.size()) {
            Element top = pq.poll();

            start = top.element;
            if (max - top.element < range) {
                start = top.element;
                end = max;
                range = end - start;
            }

            if (top.col + 1 < nums.get(top.row).size()) {
                top.element = nums.get(top.row).get(top.col + 1);
                top.col = top.col + 1;

                max = Math.max(end, top.element);
                pq.add(top);
            }
        }

        return new int[] {start, end};
    }
}
