package InsufficientNodesinRoottoLeafPaths;

/**
 * Given the root of a binary tree, consider all root to leaf paths: paths from the root to any leaf.  (A leaf is a node with no children.)

 A node is insufficient if every such root to leaf path intersecting this node has sum strictly less than limit.

 Delete all insufficient nodes simultaneously, and return the root of the resulting binary tree.
 */
public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (null == root) return null;

        if (root.left == null && root.right == null) {
            if (root.val < limit) {
                return null;
            } else {
                return root;
            }
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        return root.left == root.right ? null : root;
    }
}
