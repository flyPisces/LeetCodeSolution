package BinaryTreePaths;

import java.util.*;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 * Created by aoshen on 7/24/16.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();

        if (root != null) {
            bt_path_helper(results, "", root);
        }

        return results;
    }

    private void bt_path_helper(List<String> results, String result, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root != null && root.left == null && root.right == null) {
            results.add(result + root.val);
            return;
        }

        bt_path_helper(results, result + root.val + "->", root.left);
        bt_path_helper(results, result + root.val + "->", root.right);
    }
}
