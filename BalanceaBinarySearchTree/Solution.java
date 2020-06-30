package BalanceaBinarySearchTree;


import java.util.ArrayList;
import java.util.List;

/**
 *
 Given a binary search tree, return a balanced binary search tree with the same node values.

 A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

 If there is more than one answer, return any of them.
 */
public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);

        return bst(list, 0, list.size() - 1);
    }

    private TreeNode bst(List<TreeNode> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = list.get(mid);
        root.left = bst(list, start, mid - 1);
        root.right = bst(list, mid + 1, end);
        return root;
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }
}
