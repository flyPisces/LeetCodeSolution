package MinimumDistanceBetweenBSTNodes;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

 Example :

 Input: root = [4,2,6,1,3,null,null]
 Output: 1
 Explanation:
 Note that root is a TreeNode object, not an array.

 The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

 4
 /   \
 2      6
 / \
 1   3

 while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 */
public class Solution {
    int ans = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);

        return ans;
    }

    private void inorder(TreeNode root) {
        if (null == root) return;

        inorder(root.left);

        if (prev != null) {
            Integer curr = root.val;
            ans = Math.min(ans, curr - prev);
        }
        prev = root.val;

        inorder(root.right);
    }
}
