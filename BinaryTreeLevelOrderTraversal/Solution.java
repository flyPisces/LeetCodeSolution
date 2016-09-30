package BinaryTreeLevelOrderTraversal;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
    3
    / \
    9  20
    /  \
    15   7
    return its level order traversal as:
    [
    [3],
    [9,20],
    [15,7]
    ]
    confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * Created by aoshen on 4/19/16.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return results;
        }

        List<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        List<TreeNode> next = new ArrayList<TreeNode>();

        while (!cur.isEmpty()) {
            for (TreeNode node : cur) {
                result.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }

            results.add(new ArrayList<Integer>(result));
            result.clear();

            cur.clear();
            cur.addAll(next);
            next.clear();
        }

        return results;
    }
}
