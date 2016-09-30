package CountofRangeSum;

import apple.laf.JRSUIUtils;

/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

 Note:
 A naive algorithm of O(n2) is trivial. You MUST do better than that.

 Example:
 Given nums = [-2, 5, -1], lower = -2, upper = 2,
 Return 3.
 The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 *
 * Created by aoshen on 5/29/16.
 */
public class Solution {

    private class TreeNode {
        long val = 0;
        int count = 1;
        int leftSize = 0;
        int rightSize = 0;

        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(long val) {
            this.val = val;
            count = 1;
            leftSize = 0;
            rightSize = 0;
            left = null;
            right = null;
        }
    }

    private TreeNode insert(TreeNode root, long newVal) {
        if (root == null) {
            return new TreeNode(newVal);
        }

        if (root.val == newVal) {
            root.count ++;
        } else if (root.val < newVal) {
            root.right = insert(root.right, newVal);
            root.rightSize ++;
        } else {
            root.left = insert(root.left, newVal);
            root.leftSize ++;
        }

        return root;
    }

    private int countSmaller(TreeNode root, long val) {
        if (root == null) {
            return 0;
        }

        if (val == root.val) {
            return root.leftSize;
        } else if (root.val < val) {
            return root.leftSize + root.count + countSmaller(root.right, val);
        } else {
            return countSmaller(root.left, val);
        }
    }

    private int countLarger(TreeNode root, long val) {
        if (root == null) {
            return 0;
        }

        if (root.val == val) {
            return root.rightSize;
        } else if (root.val > val) {
            return root.count + root.rightSize + countLarger(root.left, val);
        } else {
            return countLarger(root.right, val);
        }
    }

    private int rangeSize(TreeNode root, long lower, long upper) {
        int total = root.count + root.leftSize + root.rightSize;
        int smallerCnt = countSmaller(root, lower);
        int largerCnt = countLarger(root, upper);

        return (total - smallerCnt - largerCnt);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;

        if (null == nums || nums.length == 0) {
            return result;
        }

        long[] sums = new long[nums.length + 1];
        for (int i = 1;i <= nums.length;++ i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        TreeNode root = new TreeNode(sums[0]);

        for (int i = 1;i <= nums.length;++ i) {
            result += rangeSize(root, sums[i] - upper, sums[i] - lower);
            insert(root, sums[i]);
        }

        return result;
    }
}
