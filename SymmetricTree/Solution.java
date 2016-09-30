package SymmetricTree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
   
 * @author alshen
 *
 */

public class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isTwoMappingNodeIdentical(root.left, root.right);
    }
    
    public boolean isTwoMappingNodeIdentical(TreeNode left, TreeNode right) {
        
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else {
            if (left.val != right.val) {
                return false;
            }
        }
        
        return isTwoMappingNodeIdentical(left.left, right.right) && isTwoMappingNodeIdentical(left.right, right.left);
    }
}
