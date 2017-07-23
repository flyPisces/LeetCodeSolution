package SingleElementinaSortedArray;

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

 Example 1:
 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2
 Example 2:
 Input: [3,3,7,7,10,11,11]
 Output: 10
 Note: Your solution should run in O(log n) time and O(1) space.

 * Created by aoshen on 7/19/17.
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 1) -- mid;

            if (nums[mid] != nums[mid + 1]) {
                end = mid;
            } else {
                start += 2;
            }
        }

        return nums[start];
    }
}
