package MaximalRectangle;

import java.util.*;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 * Created by aoshen on 5/7/16.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] arr = new int[matrix[0].length];
        int max = 0;

        for (int i = 0;i < matrix.length;++ i) {
            for (int j = 0;j < matrix[0].length;++ j) {
                if (matrix[i][j] == '1') {
                    arr[j] ++;
                } else {
                    arr[j] = 0;
                }
            }

            max = Math.max(max, getMaxRectangle(arr));
        }

        return max;
    }

    public int getMaxRectangle(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> heightStack = new Stack<>();
        int max = 0;

        for (int i = 0;i != arr.length;++ i) {
            if (heightStack.isEmpty() || arr[i] > heightStack.peek()) {
                indexStack.push(i);
                heightStack.push(arr[i]);
            } else {

                int j = 0;
                while (!heightStack.isEmpty() && heightStack.peek() >= arr[i]) {
                    j = indexStack.peek();
                    max = Math.max(max, heightStack.pop() * (i - indexStack.pop()));
                }

                indexStack.push(j);
                heightStack.push(arr[i]);
            }
        }

        while (!indexStack.isEmpty()) {
            max = Math.max(max, heightStack.pop() * (arr.length - indexStack.pop()));
        }

        return max;
    }
}
