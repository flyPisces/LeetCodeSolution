package BTMaximumPathSum;

/**
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.

 *
 * Created by aoshen on 5/13/16.
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }

    public int findMax(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftMax = findMax(root.left, max);
        int rightMax = findMax(root.right, max);
        int ans = Math.max(root.val, Math.max(leftMax + root.val, rightMax + root.val));
        max[0] = Math.max(max[0], Math.max(ans, leftMax + rightMax + root.val));

        return ans;
    }
}
