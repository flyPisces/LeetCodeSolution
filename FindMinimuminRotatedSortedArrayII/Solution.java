package FindMinimuminRotatedSortedArrayII;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 *
 * Created by aoshen on 5/30/16.
 */
public class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        if (left + 1 == right) {
            return Math.min(nums[left], nums[right]);
        }

        int mid = left + (right - left) / 2;

        if (nums[left] < nums[right]) {
            return nums[left];
        } else if (nums[left] == nums[right]) {
            return findMin(nums, left + 1, right);
        } else if (nums[mid] >= nums[left]) {
            return findMin(nums, mid, right);
        } else {
            return findMin(nums, left, mid);
        }
    }
}
