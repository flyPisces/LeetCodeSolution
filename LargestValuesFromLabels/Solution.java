package LargestValuesFromLabels;

import java.util.*;

/**
 * We have a set of items: the i-th item has value values[i] and label labels[i].

 Then, we choose a subset S of these items, such that:

 |S| <= num_wanted
 For every label L, the number of items in S with label L is <= use_limit.
 Return the largest possible sum of the subset S.



 Example 1:

 Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 Output: 9
 Explanation: The subset chosen is the first, third, and fifth item.
 Example 2:

 Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 Output: 12
 Explanation: The subset chosen is the first, second, and third item.
 Example 3:

 Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 Output: 16
 Explanation: The subset chosen is the first and fourth item.
 Example 4:

 Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 Output: 24
 Explanation: The subset chosen is the first, second, and fourth item.
 */
public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int N = values.length;

        int[][] pairs = new int[N][2];
        Map<Integer, Integer> labelCount = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        for (int i = 0;i < labels.length;++ i) {
            labelCount.put(labels[i], 0);
            pairs[i][0] = values[i];
            pairs[i][1] = labels[i];
            pq.add(pairs[i]);
        }

        int max = 0, time = 0;

        while (!pq.isEmpty() && time < num_wanted) {
            int[] top = pq.poll();

            if (labelCount.get(top[1]) < use_limit) {
                time ++;
                labelCount.put(top[1], labelCount.get(top[1]) + 1);
                max += top[0];
            }
        }

        return max;
    }
}
