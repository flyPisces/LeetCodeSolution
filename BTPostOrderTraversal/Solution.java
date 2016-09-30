package BTPostOrderTraversal;

import java.util.*;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
    1
    \
    2
    /
    3
    return [3,2,1].

 * Created by aoshen on 5/1/16.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();

        if (root == null) {
            return results;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur = root;
        TreeNode prev = null;

        while (!stack.empty()) {
            cur = stack.peek();

            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    stack.pop();
                    results.add(cur.val);
                }
            } else if (cur.left == prev && cur.right != null) {
                stack.push(cur.right);
            } else {
                stack.pop();
                results.add(cur.val);
            }

            prev = cur;
        }

        return results;
    }
}
