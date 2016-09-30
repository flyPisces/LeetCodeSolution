package ConstructBTFromPreOrderAndInOrder;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 */

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        
        return builderHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode builderHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int k = 0;
        for (int i = 0;i < inorder.length;++ i) {
            if (preorder[preStart] == inorder[i]) {
                k = i;
                break;
            }
        }
        
        root.left = builderHelper(preorder, preStart + 1, preStart + k - inStart, inorder, inStart, k - 1);
        root.right = builderHelper(preorder, preStart + k - inStart + 1, preEnd, inorder, k + 1, inEnd);
        
        return root;
    }
}
