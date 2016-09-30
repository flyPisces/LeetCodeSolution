package MaximumProductSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 *
 * Created by aoshen on 5/26/16.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int max_temp = nums[0];
        int min_temp = nums[0];

        for (int i = 1;i != nums.length;++ i) {
            int a = max_temp * nums[i];
            int b = min_temp * nums[i];
            max_temp = Math.max(Math.max(a, b), nums[i]);
            min_temp = Math.min(Math.min(a, b), nums[i]);
            maxProduct = Math.max(maxProduct, max_temp);
        }

        return maxProduct;
    }
}
