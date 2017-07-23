package MissingNumber;

/**
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.

    For example,
    Given nums = [0, 1, 3] return 2.

    Note:
    Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?

    Credits:
    Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

    Subscribe to see which companies asked this question
 *  Created by aoshen on 4/2/16.
 */
public class Solution {

    // using bit manipulation, same bit as 0 while different bit will be 1
    public int missingNumber(int[] nums) {
        int res = 0;

        for (int i = 0;i < nums.length;++ i) {
            res = res ^ (i + 1) ^ nums[i];
        }

        return res;
    }
}
