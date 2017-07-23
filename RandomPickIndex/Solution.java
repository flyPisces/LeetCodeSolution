package RandomPickIndex;

import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.

 Example:

 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);

 // pick(3) should return either index 2, 3, or 4 randomly.
 Each index should have equal probability of returning.
 solution.pick(3);

 // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 solution.pick(1);

 * Created by aoshen on 9/13/16.
 */
public class Solution {
    Random random = new Random();
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {

        int result = -1;
        int num = 0;

        for (int i = 0;i < nums.length;++ i) {
            if (nums[i] == target && random.nextInt(num ++) == 0) {
                result = i;
            }
        }

        return result;
    }
}
