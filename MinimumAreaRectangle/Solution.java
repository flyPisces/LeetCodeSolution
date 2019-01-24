package MinimumAreaRectangle;

import java.util.*;

/**
 * Given a set of points in the xy-plane,
 * determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

 If there isn't any rectangle, return 0.



 Example 1:

 Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
 Output: 4
 Example 2:

 Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
 Output: 2
 */
public class Solution {
    public int minAreaRect(int[][] points) {
        TreeMap<Integer, List<Integer>> mapping = new TreeMap<>();

        for (int[] point : points) {
            int x = point[0], y = point[1];

            List<Integer> yCoords = mapping.getOrDefault(x, new ArrayList<>());
            yCoords.add(y);
            mapping.put(x, yCoords);
        }

        Map<Integer, Integer> xMapping = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : mapping.entrySet()) {
            List<Integer> yCoords = entry.getValue();
            Collections.sort(yCoords);

            for (int i = 0;i < yCoords.size();++ i) {
                for (int j = i  +1;j < yCoords.size();++ j) {
                    int y1 = yCoords.get(i), y2 = yCoords.get(j);
                    int key = 40001 * y1 + y2;

                    if (xMapping.containsKey(key)) {
                        result = Math.min(result, Math.abs(y2 - y1) * Math.abs(entry.getKey() - xMapping.get(key)));
                    }
                    xMapping.put(key, entry.getKey());
                }
            }
        }

        return result < Integer.MAX_VALUE ? result : 0;
    }
}
