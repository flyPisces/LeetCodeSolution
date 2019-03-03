package CousinsinBinaryTree;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

 Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

 We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

 Return true if and only if the nodes corresponding to the values x and y are cousins.


 Input: root = [1,2,3,4], x = 4, y = 3
 Output: false

 Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 Output: true

 Input: root = [1,2,3,null,4], x = 2, y = 3
 Output: false
 */

public class Solution {
    private int levelX;
    private int levelY;
    private TreeNode parentX;
    private TreeNode parentY;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return levelY == levelX && parentY != parentX;
    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) return;

        if (root.val == x) {
            levelX = depth;
            parentX = parent;
        }

        if (root.val == y) {
            levelY = depth;
            parentY = parent;
        }

        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}
