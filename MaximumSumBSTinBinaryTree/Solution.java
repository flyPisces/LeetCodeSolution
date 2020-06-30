package MaximumSumBSTinBinaryTree;

/**
 *
 Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 */

public class Solution {

    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int[] dfs(TreeNode treeNode) {
        if (treeNode == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = dfs(treeNode.left), right = dfs(treeNode.right);

        if (!(left != null && right != null &&
                treeNode.val > left[1] &&
                treeNode.val < right[0])) {
            return null;
        }

        int sum = treeNode.val + left[2] + right[2];
        maxSum = Math.max(maxSum, sum);

        return new int[] {Math.min(left[0], treeNode.val), Math.max(treeNode.val, right[1]), sum};
    }
}
