package Triangle;

import java.util.*;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * Created by aoshen on 5/1/16.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[] mins = new int[triangle.size()];

        for (int i = 0;i < triangle.get(triangle.size() - 1).size();++ i) {
            mins[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2;i >= 0;i --) {
            for (int j = 0;j < triangle.get(i).size();++ j) {
                mins[j] = Math.min(mins[j],mins[j + 1]) + triangle.get(i).get(j);
            }
        }

        return mins[0];
    }
}
