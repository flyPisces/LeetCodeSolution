package ClosestBinarySearchTreeValue;

import java.util.*;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

 Note:
 Given target value is a floating point.
 You are guaranteed to have only one unique value in the BST that is closest to the target.

 * Created by aoshen on 7/21/16.
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int result = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();

                if (Math.abs(target - top.val) < diff) {
                    result = top.val;
                    diff = Math.abs(target - top.val);
                }

                cur = top.right;
            }
        }

        return result;
    }
}
