package LongestUnivaluePath;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

 Note: The length of path between two nodes is represented by the number of edges between them.

 Example 1:

 Input:

 5
 / \
 4   5
 / \   \
 1   1   5
 Output:

 2
 Example 2:

 Input:

 1
 / \
 4   5
 / \   \
 4   4   5
 Output:

 2
 */
public class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) {
            dfs(root, res);
        }

        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        int lMax = root.left != null ? dfs(root.left, res) : 0;
        int rMax = root.right != null ? dfs(root.right, res) : 0;

        int resl = root.left != null && root.left.val == root.val ? lMax + 1 : 0;
        int resr = root.right != null && root.right.val == root.val ? rMax + 1 : 0;

        res[0] = Math.max(res[0], resl + resr);

        return Math.max(resl, resr);
    }
}
