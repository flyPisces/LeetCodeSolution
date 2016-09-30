package ProductofArrayExceptSelf;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Created by aoshen on 5/26/16.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] results = new int[nums.length];
        int product = 1;
        results[0] = 1;
        for (int i = 1;i != nums.length;++ i) {
            product *= nums[i - 1];
            results[i] = product;
        }

        product = 1;
        for (int i = nums.length - 2;i >= 0;-- i){
            product *= nums[i + 1];
            results[i] *= product;
        }

        return results;
    }
}
