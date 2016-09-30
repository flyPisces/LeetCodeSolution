package MajorityElement;

/**
 *  Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

 *  Created by aoshen on 6/9/16.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = nums[0];

        for (int i= 0;i < nums.length;++ i) {
            if (count == 0 || result == nums[i]) {
                result = nums[i];
                count ++;
            } else {
                count --;
            }
        }

        return result;
    }
}
