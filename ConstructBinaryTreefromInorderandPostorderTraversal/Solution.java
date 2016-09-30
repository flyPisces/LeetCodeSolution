package ConstructBinaryTreefromInorderandPostorderTraversal;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Created by aoshen on 4/29/16.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int step = 0;
        for (int i = inStart;i < inEnd;++ i) {
            if (postorder[postEnd] == inorder[i]) {
                break;
            }
            step ++;
        }

        root.left = buildTree(inorder, inStart, inStart + step - 1, postorder, postStart, postStart + step - 1);
        root.right = buildTree(inorder, inStart + step + + 1, inEnd, postorder, postStart + step, postEnd - 1);

        return root;
    }
}
