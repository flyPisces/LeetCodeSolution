package CountNumberofNiceSubarrays;

import java.util.*;

/**
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0, 1);
        int sum = 0, result = 0;

        for (int num : nums) {
            if (num % 2 == 1) {
                sum ++;
            }

            mapping.put(sum, mapping.getOrDefault(sum, 0) + 1);
            result += mapping.getOrDefault(sum - k, 0);
        }

        return result;
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        int i = 0, result = 0, count = 0;

        for (int j = 0;j < nums.length;++ j) {
            if (nums[j] % 2 == 1) {
                -- k;
                count = 0;
            }

            while (k == 0) {
                k += nums[i ++] % 2;
                count ++;
            }

            result += count;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numberOfSubarrays(new int[] {1,1,2,1,1}, 3));
    }
}
