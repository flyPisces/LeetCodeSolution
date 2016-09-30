package CountCompleteTreeNodes;

/**
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 * Created by aoshen on 6/25/16.
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftHeight = getLeftTreeHeight(root);
        int rightHeight = getRightTreeHeight(root);

        if (leftHeight == rightHeight) {
            return (2 << leftHeight - 1) - 1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int getLeftTreeHeight(TreeNode root) {
        if (root == null) return 0;

        int height = 0;

        while (root != null) {
            height ++;
            root = root.left;
        }

        return height;
    }

    private int getRightTreeHeight(TreeNode root) {
        if (root == null) return 0;

        int height = 0;

        while (root != null) {
            height ++;
            root = root.right;
        }

        return height;
    }
}
