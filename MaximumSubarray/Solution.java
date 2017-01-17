package MaximumSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 * Created by aoshen on 10/27/16.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int temp = nums[0];
        int max = temp;

        for (int i = 1;i < nums.length;++ i) {
            temp = temp < 0 ? nums[i] : (temp + nums[i]);
            max = Math.max(temp, max);
        }

        return max;
    }
}
