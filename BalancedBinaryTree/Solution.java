package BalancedBinaryTree;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return !(getTreeHeight(root) == -1);
    }
    
    public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left_height = getTreeHeight(root.left);
        int right_height = getTreeHeight(root.right);
        
        if (left_height == -1 || right_height == -1) {
            return -1;
        }
        
        if (Math.abs(left_height - right_height) > 1) {
            return -1;
        }
        
        return Math.max(left_height + 1, right_height + 1);
    }
}
