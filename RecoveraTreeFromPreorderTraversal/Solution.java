package RecoveraTreeFromPreorderTraversal;

import java.util.*;

/**
 *
 We run a preorder depth first search on the root of a binary tree.

 At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)

 If a node has only one child, that child is guaranteed to be the left child.

 Given the output S of this traversal, recover the tree and return its root.
 */
public class Solution {
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();

        int level = 0, val = 0;

        for (int i = 0;i < S.length();) {
            for (level = 0;i < S.length() && S.charAt(i) == '-';++ i) {
                level ++;
            }

            for (val = 0;i < S.length() && S.charAt(i) != '-';++ i) {
                val = 10 * val + (S.charAt(i) - '0');
            }

            TreeNode node = new TreeNode(val);

            while (stack.size() > level) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }
}
