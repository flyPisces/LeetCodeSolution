package OneThreeTwoPattern;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

 Note: n will be less than 15,000.

 Example 1:
 Input: [1, 2, 3, 4]

 Output: False

 Explanation: There is no 132 pattern in the sequence.
 Example 2:
 Input: [3, 1, 4, 2]

 Output: True

 Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 Example 3:
 Input: [-1, 3, 2, 0]

 Output: True

 Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

 * Created by aoshen on 11/19/16.
 */
public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int start = 0;
        while (start < nums.length - 1) {
            while (start < nums.length - 1 && nums[start] >= nums[start + 1]) start ++;
            int m = start + 1;
            while (m < nums.length - 1 && nums[m] <= nums[m + 1]) m ++;
            int j = m + 1;
            while (j < nums.length) {
                if (nums[start] < nums[j] && nums[j] < nums[m]) return true;
                j ++;
            }
            start = m + 1;
        }

        return false;
    }
}