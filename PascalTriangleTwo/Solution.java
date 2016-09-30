package PascalTriangleTwo;

import java.util.*;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

 * Created by aoshen on 7/11/16.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        if (rowIndex < 0) {
            return result;
        }

        result.add(1);
        for (int i = 1;i <= rowIndex;++ i) {
            for (int j = result.size() - 2;j >= 0;j --) {
                result.set(j + 1, result.get(j + 1) + result.get(j));
            }
            result.add(1);
        }

        return result;
    }
}
