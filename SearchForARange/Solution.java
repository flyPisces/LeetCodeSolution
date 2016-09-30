package SearchForARange;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
 * Created by aoshen on 4/9/16.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        if (nums == null || nums.length == 0) {
            return res;
        }

        int start = 0;
        int end = nums.length - 1;

        if (nums[start] > target || nums[end] < target) {
            return res;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                res[0] = getLeftMostIndex(nums, 0, mid, target);
                res[1] = getRightMostIndex(nums, mid, nums.length - 1, target);

                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public int getLeftMostIndex(int[] nums, int start, int end, int target) {
        int leftMost = end;

        if (nums[start] == target) return start;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (mid != 0 && nums[mid - 1] < target) {
                    return mid;
                }
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return leftMost;
    }

    public int getRightMostIndex(int[] nums, int start, int end, int target) {
        int rightMost = start;

        if (nums[end] == target) return end;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                if (mid != nums.length - 1 && nums[mid + 1] > target) {
                    return mid;
                }
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return rightMost;
    }
}
