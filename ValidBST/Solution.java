package ValidBST;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
 *
 */

public class Solution {
    
    private int lastVal = Integer.MIN_VALUE;
    private boolean isRoot = true;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!isValidBST(root.left)) {
            return false;
        }
        
        if (!isRoot && root.val <= lastVal) {
            return false;
        }
        
        isRoot = false;
        lastVal = root.val;
        
        return isValidBST(root.right);
    }
    

}
