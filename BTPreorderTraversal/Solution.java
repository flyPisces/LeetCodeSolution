package BTPreorderTraversal;

import java.util.*;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
    1
    \
    2
    /
    3
    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?
 *
 * Created by aoshen on 4/23/16.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                results.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return results;
    }
}
