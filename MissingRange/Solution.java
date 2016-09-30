package MissingRange;

import java.util.*;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

 For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

 * Created by aoshen on 7/11/16.
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        int prev = lower - 1, curr = 0;

        for (int i = 0;i <= nums.length;++ i) {
            curr = i == nums.length ? upper + 1 : nums[i];

            if (curr - prev > 1) {
                result.add(getRange(prev + 1, curr - 1));
            }

            prev = curr;
        }

        return result;
    }

    private String getRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }
}
