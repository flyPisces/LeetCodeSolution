package RecoverBinarySearchTree;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

    Recover the tree without changing its structure.
 *
 * Created by aoshen on 5/28/16.
 */
public class Solution {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);

        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
        }

        inorderTraverse(root.right);
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}

