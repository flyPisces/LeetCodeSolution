package FlipBinaryTreeToMatchPreorderTraversal;

import java.util.*;

/**
 * Given a binary tree with N nodes, each node has a different value from {1, ..., N}.

 A node in this binary tree can be flipped by swapping the left child and the right child of that node.

 Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.

 (Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)

 Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.

 If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.

 If we cannot do so, then return the list [-1].
 */
public class Solution {

    List<Integer> ans = new ArrayList<>();
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        dfs(root, voyage);
        if (!ans.isEmpty() && ans.get(0) == -1) {
            ans.clear();
            ans.add(-1);
        }

        return ans;
    }

    private void dfs(TreeNode root, int[] voyage) {
        if (root != null) {
            if (root.val != voyage[index ++]) {
                ans.clear();
                ans.add(-1);
                return;
            }

            if (index < voyage.length && root.left != null && voyage[index] != root.left.val) {
                ans.add(root.val);
                dfs(root.right, voyage);
                dfs(root.left, voyage);
            } else {
                dfs(root.left, voyage);
                dfs(root.right, voyage);
            }
        }
    }
}
