package TwoSumBSTs;

import java.util.Stack;

/**
 *
 Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 */
public class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();

        if (root1 == null || root2 == null) return false;
        TreeNode curr1 = root1, curr2 = root2;

        while (true) {
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) break;

            if (s1.peek().val + s2.peek().val == target) {
                s1.clear();
                s2.clear();
                return true;
            } else if (s1.peek().val + s2.peek().val < target) {
                curr1 = s1.pop().right;
            } else if (s1.peek().val + s2.peek().val > target) {
                curr2 = s2.pop().left;
            }
        }

        return false;
    }
}
