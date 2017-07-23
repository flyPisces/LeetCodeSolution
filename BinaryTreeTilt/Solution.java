package BinaryTreeTilt;

/**
 * Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference
 between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:
 Input:
 1
 /   \
 2     3
 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1

 * Created by aoshen on 4/26/17.
 */
public class Solution {
    private int tilt = 0;

    public int findTilt(TreeNode root) {
        post_order_helper(root);
        return tilt;
    }

    private int post_order_helper(TreeNode root) {
        if (null == root) return 0;
        int leftSum = post_order_helper(root.left);
        int rightSum = post_order_helper(root.right);

        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
