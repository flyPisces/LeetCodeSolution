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

    public int findMinTwo(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}
