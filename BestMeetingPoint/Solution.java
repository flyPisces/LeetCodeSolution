package BestMeetingPoint;

import java.util.*;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 For example, given three people living at (0,0), (0,4), and (2,2):

 1 - 0 - 0 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

 * Created by aoshen on 8/13/16.
 */
public class Solution {

    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        int sum = 0;
        for (int i = 0;i < grid.length;++ i) {
            for (int j = 0;j < grid[0].length;++ j) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0;i < rows.size();++ i) {
            sum += Math.abs(rows.get(i) - rows.get(rows.size() / 2));
        }

        Collections.sort(cols);
        for (int i = 0;i < cols.size();++ i) {
            sum += Math.abs(cols.get(i) - cols.get(cols.size() / 2));
        }

        return sum;
    }
}
