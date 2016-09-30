package SummaryRanges;

import java.util.*;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 * Created by aoshen on 6/27/16.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        int start = nums[0];
        int end = nums[0];
        String result = "";

        for (int i = 1;i < nums.length;++ i) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start != end) {
                    result = start + "->" + end;
                } else {
                    result = String.valueOf(start);
                }
                results.add(result);

                start = end = nums[i];
            }
        }

        if (start != end) {
            results.add(start + "->" + end);
        } else {
            results.add(String.valueOf(start));
        }

        return results;
    }
}
