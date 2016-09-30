package LargestBSTSubtree;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:
 10
 / \
 5  15
 / \   \
 1   8   7
 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.

 * Created by aoshen on 8/4/16.
 */
public class Solution {
    private int max = 0;

    class Wrapper {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int size = 0;
        boolean isBST = false;
    }

    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return max;
    }

    public Wrapper helper(TreeNode root) {
        Wrapper wrapper = new Wrapper();
        if (root == null) {
            wrapper.isBST = true;
            return wrapper;
        }

        Wrapper leftW = helper(root.left);
        Wrapper rightW = helper(root.right);

        if (leftW.isBST && rightW.isBST && root.val > leftW.max && root.val < rightW.min) {
            wrapper.isBST = true;
            wrapper.min = Math.min(root.val, leftW.min);
            wrapper.max = Math.max(root.val, rightW.max);
            wrapper.size = leftW.size + rightW.size + 1;
            max = Math.max(wrapper.size, max);
        }

        return wrapper;
    }
}
