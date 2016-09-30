package JumpGameTwo;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    For example:
    Given array A = [2,3,1,1,4]

    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Created by aoshen on 4/9/16.
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int step = 0;
        int maxCover = 0;
        int lastCover = 0;


        for (int i = 0;i <= maxCover && i < nums.length;++ i) {
            if (i > lastCover) {
                step ++;
                lastCover = maxCover;
            }

            maxCover = Math.max(maxCover, nums[i] + i);
        }

        if (maxCover < nums.length - 1) {
            step = 0;
        }

        return step;
    }
}
