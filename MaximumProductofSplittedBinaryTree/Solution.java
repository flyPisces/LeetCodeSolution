package MaximumProductofSplittedBinaryTree;

import java.util.*;

/**
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 *
 * Since the answer may be too large, return it modulo 10^9 + 7.
 */
public class Solution {

    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> subTreeSum = new HashMap<>();

        long sum = dfs(root, subTreeSum);
        long mul = 0;

        for (Map.Entry<TreeNode, Long> entry : subTreeSum.entrySet()) {
            mul = Math.max(mul, entry.getValue() * (sum - entry.getValue()));
        }

        return (int)(mul % (int)(1e9 + 7));
    }

    private long dfs(TreeNode root, Map<TreeNode, Long> subTreeSum) {
        if (null == root) return 0;

        long currSum = dfs(root.left, subTreeSum) + dfs(root.right, subTreeSum) + root.val;
        subTreeSum.put(root, currSum);

        return subTreeSum.get(root);
    }
}
