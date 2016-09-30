package BinaryTreeUpsideDown;

/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

    For example:
    Given a binary tree {1,2,3,4,5},
    1
    / \
    2   3
    / \
    4   5
    return the root of the binary tree [4,5,2,#,#,3,1].
    4
    / \
    5   2
    / \
    3   1
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

 *  Created by aoshen on 7/10/16.
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        return upsideDownBinaryTreeHelper(root, null);
    }

    private TreeNode upsideDownBinaryTreeHelper(TreeNode cur, TreeNode parent) {
        if (null == cur) {
            return parent;
        }

        TreeNode newNode = upsideDownBinaryTreeHelper(cur.left, cur);

        cur.left = parent == null ? null : parent.right;
        cur.right = parent;

        return newNode;
    }
}
