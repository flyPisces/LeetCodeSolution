package FindMinumumInRotatedSortedArray;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Find the minimum element.

    You may assume no duplicate exists in the array.

    Subscribe to see which companies asked this question
 *
 * Created by aoshen on 4/4/16.
 */
public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            min = Math.min(min, nums[mid]);
        }

        return min;
    }
}
