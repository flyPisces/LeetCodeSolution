package RangeSumQueryMutable;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:
 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8
 Note:
 The array is only modifiable by the update function.
 You may assume the number of calls to update and sumRange function is distributed evenly.

 * Created by aoshen on 8/5/16.
 */
public class NumArray {
    class TreeNode {
        int start;
        int end;
        int sum;

        TreeNode left;
        TreeNode right;

        public TreeNode(int left, int right) {
            this.start = left;
            this.end = right;
        }

        public TreeNode(int left, int right, int val) {
            this.sum = val;
            this.start = left;
            this.end = right;
        }
    }

    TreeNode root = null;

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        root = buildTrees(nums, 0, nums.length - 1);
    }

    void update(int i, int val) {
        updateHelper(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumHelper(root, i, j);
    }

    public int sumHelper(TreeNode root, int i, int j) {
        if (root == null || j < root.start || i > root.end || i > j) {
            return 0;
        }

        if (i <= root.start && root.end <= j) {
            return root.sum;
        }

        int mid = root.start + (root.end - root.start) / 2;
        int result = sumHelper(root.left, i, Math.min(j, mid)) +
                sumHelper(root.right, Math.max(mid + 1, i), j);

        return result;
    }

    public void updateHelper(TreeNode root, int idx, int val) {
        if (null == root) return;

        int mid = root.start + (root.end - root.start) / 2;
        if (idx <= mid) {
            updateHelper(root.left, idx, val);
        } else {
            updateHelper(root.right, idx, val);
        }

        if (root.start == idx && root.end == idx) {
            root.sum = val;
            return;
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public TreeNode buildTrees(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0 || left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(left, right, nums[left]);
        }

        TreeNode pRoot = new TreeNode(left, right);
        int mid = left + (right - left) / 2;

        pRoot.left = buildTrees(nums, left, mid);
        pRoot.right = buildTrees(nums, mid + 1, right);

        pRoot.sum = pRoot.left.sum + pRoot.right.sum;
        return pRoot;
    }
}
