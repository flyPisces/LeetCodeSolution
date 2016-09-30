package WiggleSortII;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

 Example:
 (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

 Note:
 You may assume all input has valid answer.

 * Created by aoshen on 6/29/16.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int rank = nums.length % 2 == 0 ?  nums.length / 2  : (nums.length + 1) / 2;
        int median = findKthSmallest(nums, 0, nums.length - 1, rank);

        int[] temp = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0;i < nums.length;++ i) {
            if (nums[i] < median) {
                temp[start++] = nums[i];
            } else if (nums[i] > median) {
                temp[end --] = nums[i];
            }
        }

        for (int i = start;i <= end;++ i) {
            temp[i] = median;
        }

        start = rank - 1;
        end = nums.length - 1;

        for (int i = 0;i < nums.length;++ i) {
            if (i % 2 == 0) {
                nums[i] = temp[start];
                start --;
            } else {
                nums[i] = temp[end];
                end --;
            }
        }
    }

    private int findKthSmallest(int[] nums, int low, int high, int rank) {
        int pivot = nums[high];

        int j = low;
        for (int i = low;i <= high - 1;++ i) {
            if (nums[i] <= pivot) {
                swap(nums, i, j);
                ++ j;
            }
        }

        swap(nums, j, high);

        if (j - low + 1 == rank) {
            return pivot;
        } else if (j - low + 1 > rank) {
            return findKthSmallest(nums, low, j - 1, rank);
        } else {
            return findKthSmallest(nums, j + 1, high, rank - (j - low + 1));
        }
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
