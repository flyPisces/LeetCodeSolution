package PascalTriangle;

import java.util.*;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

    For example, given numRows = 5,
    Return

    [
    [1],
    [1,1],
    [1,2,1],
    [1,3,3,1],
    [1,4,6,4,1]
    ]
 *
 * Created by aoshen on 4/26/16.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return results;
        }

        for (int i = 0;i < numRows;++ i) {
            List<Integer> result = new ArrayList<Integer>();

            result.add(1);
            for (int j = 1;j < i;++ j) {
                result.add(results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
            }

            if (i != 0) {
                result.add(1);
            }

            results.add(result);
        }

        return results;
    }
}
