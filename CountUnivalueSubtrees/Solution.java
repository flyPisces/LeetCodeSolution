package CountUnivalueSubtrees;

/**
 * Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,
 5
 / \
 1   5
 / \   \
 5   5   5
 return 4.

 * Created by aoshen on 8/4/16.
 */
public class Solution {
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }

    public boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            count ++;
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left == true && right == true && (root.left == null || root.left.val == root.val) &&
                (root.right == null || root.right.val == root.val)) {
            count ++;
            return true;
        }

        return false;
    }
}
