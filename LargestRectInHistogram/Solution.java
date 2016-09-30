package LargestRectInHistogram;

import java.util.Stack;
import java.util.zip.Inflater;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * For example,
    Given heights = [2,1,5,6,2,3],
    return 10.
 *
 * Created by aoshen on 4/24/16.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = 0;

        Stack<Integer> indexStack = new Stack<Integer>();
        Stack<Integer> heightStack = new Stack<Integer>();

        for (int i = 0;i < heights.length;++ i) {
            if (heightStack.empty() || heights[i] > heightStack.peek()) {
                indexStack.push(i);
                heightStack.push(heights[i]);
            } else {
                int j = 0;
                while (!indexStack.empty() && heights[i] <= heightStack.peek()) {
                    j = indexStack.peek();
                    max = Math.max(max, heightStack.pop() * (i - indexStack.pop()));
                }

                indexStack.push(j);
                heightStack.push(heights[i]);
            }
        }

        while (!indexStack.empty()) {
            max = Math.max(max, heightStack.pop() * (heights.length - indexStack.pop()));
        }

        return max;
    }
}
