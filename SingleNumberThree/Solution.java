package SingleNumberThree;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 * Created by aoshen on 7/20/16.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] results = new int[2];

        if (nums == null || nums.length == 0) return results;

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int lastBit = xor - (xor & (xor - 1));

        int group0 = 0, group1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((lastBit & nums[i]) == 0) {
                group0 ^= nums[i];
            } else {
                group1 ^= nums[i];
            }
        }

        results[0] = group0;
        results[1] = group1;

        return results;
    }
}
