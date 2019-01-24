package MinimumAreaRectangleII;

import java.util.*;

/**
 * Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points, with sides not necessarily parallel to the x and y axes.

 If there isn't any rectangle, return 0.

 Input: [[1,2],[2,1],[1,0],[0,1]]
 Output: 2.00000
 Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.

 Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
 Output: 1.00000
 Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.

 Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
 Output: 0
 Explanation: There is no possible rectangle to form from these points.

 Input: [[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
 Output: 2.00000
 Explanation: The minimum area rectangle occurs at [2,1],[2,3],[3,3],[3,1], with an area of 2.
 */
public class Solution {
    public double minAreaFreeRect(int[][] points) {
        if (points.length < 4) return 0;
        double result = Double.MAX_VALUE;

        Map<String ,List<int[]>> mapping = new HashMap<>();

        for (int i = 0;i < points.length;++ i) {
            for (int j = i + 1;j < points.length;++ j) {
                long dis = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                double centerX = (double) 0.5 * (points[i][0] + points[j][0]);
                double centerY = (double) 0.5 * (points[i][1] + points[j][1]);

                String key = dis + ":" + centerX + ":" + centerY;
                if (!mapping.containsKey(key)) {
                    mapping.put(key, new ArrayList<>());
                }

                mapping.get(key).add(new int[] {i , j});
            }
        }

        for (String key : mapping.keySet()) {
            if (mapping.get(key).size() > 1) {
                List<int[]> list = mapping.get(key);

                for (int i = 0;i < list.size();++ i) {
                    for (int j = i + 1;j < list.size();++ j) {
                        int p1 = list.get(i)[0];
                        int p2 = list.get(j)[1];
                        int p3 = list.get(j)[0];

                        double len1 = Math.sqrt((points[p1][0] - points[p2][0]) * (points[p1][0] - points[p2][0]) + (points[p1][1] - points[p2][1]) * (points[p1][1] - points[p2][1]));
                        double len2 = Math.sqrt((points[p1][0] - points[p3][0]) * (points[p1][0] - points[p3][0]) + (points[p1][1] - points[p3][1]) * (points[p1][1] - points[p3][1]));
                        double area = len1 * len2;

                        result = Math.min(result, area);
                    }
                }
            }
        }

        return result == Double.MAX_VALUE ? 0 : result;
    }
}
