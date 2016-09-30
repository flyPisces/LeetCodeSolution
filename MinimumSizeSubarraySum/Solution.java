package MinimumSizeSubarraySum;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

    For example, given the array [2,3,1,2,4,3] and s = 7,
    the subarray [4,3] has the minimal length under the problem constraint.
 * 
 *
 */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        
        int left = 0, right = 0, sum = 0, minLen = nums.length + 1;
        
        while (right < nums.length) {
            while (sum < s && right < nums.length) {
                sum += nums[right++];
            }
            
            while (sum >= s) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left++];
            }
        }
        
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}
