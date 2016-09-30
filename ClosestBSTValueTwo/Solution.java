package ClosestBSTValueTwo;

import java.util.*;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

 Note:
 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 Follow up:
 Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

 * Created by aoshen on 7/24/16.
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Stack<Integer> preStack = new Stack<>();
        Stack<Integer> postStack = new Stack<>();

        getPostdecessor(root, postStack, target);
        getPredecessor(root, preStack, target);

        for (int i = 0;i < k;++ i) {
            if (preStack.isEmpty()) {
                results.add(postStack.pop());
            } else if (postStack.isEmpty()) {
                results.add(preStack.pop());
            } else if (Math.abs((double)(preStack.peek() - target)) <= Math.abs((double)(postStack.peek() - target))) {
                results.add(preStack.pop());
            } else {
                results.add(postStack.pop());
            }
        }

        return results;
    }

    private void getPredecessor(TreeNode root, Stack<Integer> preStack, double target) {
        if (root == null) {
            return;
        }

        getPredecessor(root.left, preStack, target);

        if (root.val > target) {
            return;
        }

        preStack.push(root.val);

        getPredecessor(root.right, preStack, target);
    }

    private void getPostdecessor(TreeNode root, Stack<Integer> postStack, double target) {
        if (root == null) {
            return;
        }

        getPostdecessor(root.right, postStack, target);

        if (root.val <= target) {
            return;
        }

        postStack.push(root.val);

        getPostdecessor(root.left, postStack, target);
    }
}
