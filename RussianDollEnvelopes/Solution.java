package RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.*;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Example:
 Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

 * Created by aoshen on 6/18/16.
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }

        int[] nums = new int[envelopes.length];
        int max = 0;

        Arrays.fill(nums, 1);
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0;i < envelopes.length;++ i) {
            for (int k = i - 1;k >= 0;-- k) {
                if (envelopes[i][0] > envelopes[k][0] && envelopes[i][1] > envelopes[k][1]) {
                    nums[i] = Math.max(nums[i], nums[k] + 1);
                }
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
