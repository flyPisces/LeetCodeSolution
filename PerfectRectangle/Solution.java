package PerfectRectangle;

import java.util.HashSet;
import java.util.Set;

/**
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

 Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

 *
 * Created by aoshen on 9/2/16.
 */
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int bottom = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int top = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        int totalSum = 0;
        Set<String> set = new HashSet<>();

        for (int[] arr : rectangles) {
            int b = arr[0];
            int l = arr[1];
            int t = arr[2];
            int r = arr[3];

            bottom = Math.min(bottom, b);
            left = Math.min(left, l);
            top = Math.max(top, t);
            right = Math.max(right, r);

            totalSum += (t - b) * (r - l);

            String lb = l + "," + b;
            String lt = l + "," + t;
            String rt = r + "," + t;
            String rb = r + "," + b;

            if (set.contains(lb))
                set.remove(lb);
            else
                set.add(lb);
            if (set.contains(lt))
                set.remove(lt);
            else
                set.add(lt);
            if (set.contains(rt))
                set.remove(rt);
            else
                set.add(rt);
            if (set.contains(rb)) {
                set.remove(rb);
            } else
                set.add(rb);
        }

        if (set.size() == 4 && totalSum == (top - bottom) * (right - left) && set.contains(left + "," + bottom) &&
                set.contains(left + "," + top) && set.contains(right + "," + top) && set.contains(right + "," + top)) {
            return true;
        }

        return false;
    }
}
