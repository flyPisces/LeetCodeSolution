package FindSmallestCommonElementinAllRows;

import java.util.*;

/**
 * Given a matrix mat where every row is sorted in increasing order, return the smallest common element in all rows.
 *
 * If there is no common element, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * Output: 5
 */
public class Solution {
    public int smallestCommonElement(int[][] mat) {
        int result = Integer.MAX_VALUE ;

        Map<Integer, Integer> mapping = new HashMap<>();
        int ROWS = mat.length, COLS = mat[0].length;

        for (int[] arr : mat) {
            if (mapping.containsKey(arr[0])) {
                mapping.put(arr[0], mapping.get(arr[0]) + 1);
            } else {
                mapping.put(arr[0], 1);
            }

            for (int j = 1;j < COLS;++ j) {
                if (arr[j - 1] == arr[j]) continue;

                if (mapping.containsKey(arr[j])) {
                    mapping.put(arr[j], mapping.get(arr[j]) + 1);
                } else {
                    mapping.put(arr[j], 1);
                }
             }
        }

        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            if (entry.getValue() == ROWS) {
                result = Math.min(result, entry.getKey());
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
