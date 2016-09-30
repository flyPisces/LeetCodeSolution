package SingleNumberTwo;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 * Created by aoshen on 7/3/16.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] counts = new int[32];

        for (int i = 0;i < nums.length;++ i) {
            for (int j = 0;j < 32;++ j) {
                if ((nums[i] >> j & 1) == 1) {
                    counts[j] ++;
                }
            }
        }

        int res = 0;
        for (int i = 0;i < 32;++ i) {
            res += (counts[i] % 3) << i;
        }

        return res;
    }
}
