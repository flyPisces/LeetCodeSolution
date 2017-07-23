package AddOneRowtoTree;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

 The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

 Example 1:
 Input:
 A binary tree as following:
 4
 /   \
 2     6
 / \   /
 3   1 5

 v = 1

 d = 2

 Output:
 4
 / \
 1   1
 /     \
 2       6
 / \     /
 3   1   5

 Example 2:
 Input:
 A binary tree as following:
 4
 /
 2
 / \
 3   1

 v = 1

 d = 3

 Output:
 4
 /
 2
 / \
 1   1
 /     \
 3       1

 * Created by aoshen on 6/28/17.
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (1 == d) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        add(root, v, d, 1);

        return root;
    }

    private void add(TreeNode root, int v, int d, int currDepth) {
        if (null == root) {
            return;
        }

        if (currDepth == d - 1) {
            TreeNode temp = root.left;
            root.left = new TreeNode(v);
            root.left.left = temp;

            temp = root.right;
            root.right = new TreeNode(v);
            root.right.right = temp;
            return;
        }

        add(root.left, v, d, currDepth + 1);
        add(root.right, v, d, currDepth + 1);
    }
}
