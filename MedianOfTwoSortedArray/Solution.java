package MedianOfTwoSortedArray;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        
        if (total % 2 == 0) {
            return  (findKth(0, nums1, 0, nums2, total / 2) + findKth(0, nums1, 0, nums2, total / 2 + 1) ) / 2.0;
        } else {
            return findKth(0, nums1, 0, nums2, total / 2 + 1);
        }
    }
    
    public int findKth(int startNums1, int[] nums1, int startNums2, int[] nums2, int k) {
        if (startNums1 >= nums1.length) {
            return nums2[startNums2 + k - 1];
        }
        if (startNums2 >= nums2.length) {
            return nums1[startNums1 + k - 1];
        }
        
        if (k == 1) {
            return Math.min(nums1[startNums1], nums2[startNums2]);
        }
        
        int median1 = (startNums1 + k / 2 - 1 < nums1.length) ? nums1[startNums1 + k / 2 - 1] : Integer.MAX_VALUE;
        int median2 = (startNums2 + k / 2 - 1 < nums2.length) ? nums2[startNums2 + k / 2 - 1] : Integer.MAX_VALUE;
        
        if (median1 >= median2) {
            return findKth(startNums1, nums1, startNums2 + k / 2, nums2, k - k / 2);
        } else {
            return findKth(startNums1 + k / 2, nums1, startNums2, nums2, k - k / 2);
        }
    }
}
