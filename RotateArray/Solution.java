package RotateArray;

/**
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

 [show hint]

 Related problem: Reverse Words in a String II

 * Created by aoshen on 8/13/16.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        assert (nums != null && nums.length != 0 && k >= 0);

        if (k > nums.length) {
            k = k % nums.length;
        }

        int pivot = nums.length - k;

        reverse(nums, 0, pivot - 1);
        reverse(nums, pivot, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if (nums == null || nums.length == 1) {
            return;
        }

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start ++;
            end --;
        }
    }
}
