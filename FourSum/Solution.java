package FourSum;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 *
 * Created by aoshen on 5/14/16.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (null == nums || nums.length < 4) {
            return results;
        }

        Arrays.sort(nums);

        for (int i = 0;i < nums.length - 3;++ i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1;j < nums.length - 2;++ j) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                List<List<Integer>> partialResults = twoSums(target - nums[i] - nums[j], nums, j + 1);
                for (List<Integer> partialResult : partialResults) {
                    partialResult.add(0, nums[j]);
                    partialResult.add(0, nums[i]);

                    results.add(partialResult);
                }
            }
        }

        return results;
    }

    public List<List<Integer>> twoSums(int target, int[] nums, int start) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();;

        int i = start;
        int j = nums.length - 1;

        while (i < j && i <= nums.length - 1 && j >= start) {

            if (nums[i] + nums[j] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(nums[j]);
                results.add(result);
                ++ i;
                -- j;
            } else if (nums[i] + nums[j] < target) {
                ++ i;
            } else {
                -- j;
            }

            while (i != start && i <= nums.length - 1 && nums[i] == nums[i - 1]) {
                i ++;
            }

            while (j < nums.length - 1 && j >= start && nums[j] == nums[j + 1]) {
                j --;
            }
        }

        return results;
    }
}
