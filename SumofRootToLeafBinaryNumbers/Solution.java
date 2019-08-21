package SumofRootToLeafBinaryNumbers;

/**
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

 For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

 Return the sum of these numbers.


 */
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (null == root) return 0;

        val = 2 *val + root.val;

        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}
