package BTInorderTraversal;

import java.util.*;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
    1
    \
    2
    /
    3
    return [1,3,2].

 * Created by aoshen on 4/23/16.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                results.add(root.val);
                root = root.right;
            }
        }

        return results;
    }
}
