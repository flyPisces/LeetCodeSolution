package MaximumDifferenceBetweenNodeandAncestor;

/**
 * Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

 (A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)

 Input: [8,3,10,1,6,null,14,null,null,4,7,13]
 Output: 7
 Explanation:
 We have various ancestor-node differences, some of which are given below :
 |8 - 3| = 5
 |3 - 7| = 4
 |8 - 1| = 7
 |10 - 13| = 3
 Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 */
public class Solution {

    int diff = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);

        return diff;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) return;

        diff = Math.max(diff, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));

        dfs(root.left, Math.min(root.val, min), Math.max(root.val, max));
        dfs(root.right, Math.min(root.val, min), Math.max(root.val, max));
    }
}
