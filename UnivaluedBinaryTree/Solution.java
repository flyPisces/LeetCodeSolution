package UnivaluedBinaryTree;

/**
 * A binary tree is univalued if every node in the tree has the same value.

 Return true if and only if the given tree is univalued.
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (null == root) return true;

        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode treeNode, int val) {
        if (treeNode == null) return true;
        if (treeNode.val != val) return false;

        return dfs(treeNode.left, val) && dfs(treeNode.right, val);
    }
}
