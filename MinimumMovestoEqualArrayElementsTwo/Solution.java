package MinimumMovestoEqualArrayElementsTwo;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.

 Example:

 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

 * Created by aoshen on 11/20/16.
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        while (start < end) {
            result += nums[end] - nums[start];
            start ++;
            end --;
        }

        return result;
    }
}
