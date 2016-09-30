package SumofLeftLeaves;

/**
 * Created by aoshen on 9/27/16.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) return 0;
        return helper(root, root.left) + helper(root, root.right);
    }

    public int helper(TreeNode parent, TreeNode curr) {
        if (parent == null || curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && parent.left == curr) {
            return curr.val;
        }

        return helper(curr, curr.left) + helper(curr, curr.right);
    }
}
