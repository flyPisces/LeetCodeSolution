package BSTTOGST;

/**
 *
 Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

 As a reminder, a binary search tree is a tree that satisfies these constraints:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */

public class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        pst(root);

        return root;
    }

    private void pst(TreeNode root) {
        if (null == root) return;
        pst(root.right);

        sum += root.val;
        root.val = sum;

        pst(root.left);
    }
}
