package MaxPointsInALine;

import java.util.*;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Created by aoshen on 5/1/16.
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int max = 1;

        if (points == null || points.length == 0) {
            return 0;
        }

        if (points.length == 1) {
            return 1;
        }

        for (int i = 0;i != points.length;++ i) {
            int samePoint = 0;
            int localMax = 1;
            Map<Float, Integer> map = new HashMap<Float, Integer>();

            for (int j = 0;j != points.length;++ j) {
                if (i == j) {
                    continue;
                }

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePoint ++;
                    continue;
                }

                float slope = ((float)(points[j].y - points[i].y)) / (points[j].x - points[i].x);

                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope) + 1);
                } else {
                    map.put(slope, 2);
                }
            }

            for (Integer num : map.values()) {
                localMax = Math.max(localMax, num);
            }

            localMax += samePoint;
            max = Math.max(localMax, max);
        }

        return max;
    }
}
