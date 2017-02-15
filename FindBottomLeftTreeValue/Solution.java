package FindBottomLeftTreeValue;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:
 Input:

 2
 / \
 1   3

 Output:
 1
 Example 2:
 Input:

 1
 / \
 2   3
 /   / \
 4   5   6
 /
 7

 Output:
 7
 Note: You may assume the tree (i.e., the given root node) is not NULL.

 * Created by aoshen on 2/13/17.
 */
public class Solution {
    int dep = 0, ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return ans;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (dep < depth) {
            ans = root.val;
            dep = depth;
        }

        if (root.left != null) helper(root.left, depth + 1);
        if (root.right != null) helper(root.right, depth + 1);
    }
}
