package ConstructBinarySearchTreefromPreorderTraversal;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.

 (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)



 Example 1:

 Input: [8,5,1,7,10,12]
 Output: [8,5,10,1,7,null,12]
 */
public class Solution {

    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound) return null;

        TreeNode root = new TreeNode(preorder[idx]);
        idx ++;
        root.left = helper(preorder, root.val);
        root.right = helper(preorder, bound);

        return root;
    }
}
