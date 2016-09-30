package SortColors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Created by aoshen on 4/13/16.
 */
public class Solution {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int notRed = 0;
        int notBlue = nums.length - 1;

        while (notRed < nums.length && nums[notRed] == 0) {
            notRed ++;
        }

        while (notBlue >= 0 && nums[notBlue] == 2) {
            notBlue --;
        }

        int index = notRed;
        while (index <= notBlue) {
            if (nums[index] == 0) {
                swap(nums, index, notRed);
                notRed ++;
                index ++;
            } else if (nums[index] == 2) {
                swap(nums, index, notBlue);
                notBlue --;
            } else {
                index ++;
            }
        }
    }
}
