package DistributeCoinsinBinaryTree;

/**
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

 In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

 Return the number of moves required to make every node have exactly one coin.


 */
public class Solution {

    int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return  result;
    }

    private int dfs(TreeNode root) {
        if (null == root) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        result += Math.abs(left) + Math.abs(right);

        return left + right + root.val - 1;
    }
}
