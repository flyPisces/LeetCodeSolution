package SortTransformedArray;

/**
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

 The returned array must be in sorted order.

 Expected time complexity: O(n)

 Example:
 nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

 Result: [3, 9, 15, 33]

 nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

 Result: [-23, -5, 1, 7]

 * Created by aoshen on 7/25/16.
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int size = nums.length;
        int[] results = new int[size];

        if (a == 0) {
            if (b >= 0) {
                for (int i = 0;i < size;++ i) {
                    results[i] = b * nums[i] + c;
                }
            } else {
                for (int i = 0;i < size;++ i) {
                    results[i] = b * nums[size - 1 - i] + c;
                }
            }
        } else {
            double mid = -(double) b / (2 * a);

            int peakIndex = findPeakIndex(mid, nums);
            int start = peakIndex,end = peakIndex + 1;
            int index = 0;

            if (a > 0) {
                index = 0;
                while (start >= 0 && end < nums.length) {
                    if (Math.abs(nums[start] - mid) <= Math.abs(nums[end] - mid)) {
                        results[index ++] = a * nums[start] * nums[start] + b * nums[start] + c;
                        start --;
                    } else {
                        results[index ++] = a * nums[end] * nums[end] + b * nums[end] + c;
                        end ++;
                    }
                }

                while (start >= 0) {
                    results[index ++] = a * nums[start] * nums[start] + b * nums[start] + c;
                    start --;
                }

                while (end < nums.length) {
                    results[index ++] = a * nums[end] * nums[end] + b * nums[end] + c;
                    end ++;
                }
            } else {
                index = size - 1;

                while (start >= 0 && end < nums.length) {
                    if (Math.abs(nums[start] - mid) <= Math.abs(nums[end] - mid)) {
                        results[index --] = a * nums[start] * nums[start] + b * nums[start] + c;
                        start --;
                    } else {
                        results[index --] = a * nums[end] * nums[end] + b * nums[end] + c;
                        end ++;
                    }
                }

                while (start >= 0) {
                    results[index --] = a * nums[start] * nums[start] + b * nums[start] + c;
                    start --;
                }

                while (end < nums.length) {
                    results[index --] = a * nums[end] * nums[end] + b * nums[end] + c;
                    end ++;
                }
            }
        }

        return results;
    }

    private int findPeakIndex(double mid, int[] nums) {
        double diff = Double.MAX_VALUE;
        int index = 0;

        for (int i = 0;i < nums.length;++ i) {
            if (diff > Math.abs(mid - nums[i])) {
                index = i;
                diff = Math.abs(mid - nums[i]);
            }
        }

        return index;
    }
}
