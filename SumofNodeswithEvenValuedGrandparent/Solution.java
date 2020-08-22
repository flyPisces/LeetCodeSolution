package SumofNodeswithEvenValuedGrandparent;

/**
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
 *
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
 */
public class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private int dfs(TreeNode root, int parent, int grandParent) {
        if (null == root) return 0;

        return dfs(root.left, root.val, parent) + dfs(root.right, root.val, parent) + (grandParent % 2 == 0 ? root.val : 0);
    }
}
