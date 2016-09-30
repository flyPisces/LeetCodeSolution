package RangeSumQueryImmutable;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.

 * Created by aoshen on 8/3/16.
 */
public class NumArray {
    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];

        for (int i = 1;i <= nums.length;++ i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        assert (i <= j);
        assert (i >= 0);
        assert (j < sums.length);

        int startSum = sums[i];
        int endSum = sums[j + 1];

        return endSum - startSum;
    }
}
