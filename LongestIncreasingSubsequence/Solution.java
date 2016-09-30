package LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 * Created by aoshen on 8/2/16.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> results = new ArrayList<>();

        for (int num : nums) {
            if (results.size() == 0) {
                results.add(num);
            } else if (num > results.get(results.size() - 1)) {
                results.add(num);
            } else {
                int start = 0;
                int end = results.size() - 1;

                while (start < end) {
                    int mid = start + (end - start) / 2;

                    if (results.get(mid) < num) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                results.set(start, num);
            }
        }

        return results.size();
    }
}
