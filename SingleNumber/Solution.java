package SingleNumber;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Created by aoshen on 4/16/16.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int singleNum = 0;

        for (int i = 0;i != nums.length;++ i) {
            singleNum = singleNum ^ nums[i];
        }

        return singleNum;
    }
}
