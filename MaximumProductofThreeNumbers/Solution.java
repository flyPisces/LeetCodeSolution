package MaximumProductofThreeNumbers;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24

 * Created by aoshen on 6/26/17.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int size = nums.length;

        return Math.max(nums[size - 1] * nums[size - 2] * nums[size - 3],
                nums[0] * nums[1] * nums[size - 1]);
    }
}
