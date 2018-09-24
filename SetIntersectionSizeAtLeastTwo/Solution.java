package SetIntersectionSizeAtLeastTwo;

import java.util.*;

/**
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b,
 * including a and b.

 Find the minimum size of a set S such that for every integer interval A in intervals,
 the intersection of S with A has size at least 2.

 Example 1:
 Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 Output: 3
 Explanation:
 Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
 Also, there isn't a smaller size set that fulfills the above condition.
 Thus, we output the size of this set, which is 3.
 Example 2:
 Input: intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
 Output: 5
 Explanation:
 An example of a minimum sized set is {1, 2, 3, 4, 5}.
 */
public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        // One case that is important to handle is the following: [[1, 2], [2, 3], [2, 4], [4, 5]]. If we put 4, 5 in S,
        // then we put 2 in S, when handling [2, 3] we need to put 3 in S, not 2 which was already put.
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int ans = 0;
        int size = intervals.length;
        int[] dp = new int[size];
        Arrays.fill(dp, 2);

        for (int i = size - 1;i >= 0;-- i) {
            int temp = dp[i];

            for (int k = 0;k < temp;++ k) {
                int num = intervals[i][0] + k;

                for (int j = 0;j < i;++ j) {
                    if (dp[j] > 0 && num <= intervals[j][1]) {
                        -- dp[j];
                    }
                }

                ans ++;
            }
        }

        return ans;
    }
}
