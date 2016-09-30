package RemoveDuplicatesFromSortedArrayTwo;

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 * Created by aoshen on 5/4/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int index = 0;
        int lastVal = nums[0];
        int times = 1;

        for (int i = 1;i < nums.length;++ i) {
            if (nums[i] == lastVal) {
                times ++;
                if (times == 2) {
                    nums[++index] = nums[i];
                }
            } else {
                nums[++index] = nums[i];
                lastVal = nums[i];
                times = 1;
            }
        }

        return (index + 1);
    }
}

