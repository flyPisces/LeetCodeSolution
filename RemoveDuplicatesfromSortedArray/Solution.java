package RemoveDuplicatesfromSortedArray;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

 * Created by aoshen on 10/16/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) return 1;

        int prev = nums[0];
        int count = 1;

        for (int i = 1;i < nums.length;++ i) {
            if (nums[i] != prev) {
                prev = nums[i];
                nums[count ++] = prev;
            }
        }

        return count;
    }
}
