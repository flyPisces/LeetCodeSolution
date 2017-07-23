package KthSmallestElementinaSortedMatrix;

import java.util.*;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.

 * Created by aoshen on 7/31/16.
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) return 0;

        int SIZE = matrix.length;
        PriorityQueue<Element> pq = new PriorityQueue<>(SIZE, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0;i < SIZE;++ i) {
            Element ele = new Element(matrix[0][i], 0, i);
            pq.offer(ele);
        }

        int time = 0;
        int result = 0;
        while (time < k) {
            Element top = pq.poll();
            result = top.val;

            top.row ++;
            if (top.row < SIZE) {
                top.val = matrix[top.row][top.col];
                pq.offer(top);
            }

            time ++;
        }

        return result;
    }

    class Element {
        int val;
        int row;
        int col;

        Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
}
