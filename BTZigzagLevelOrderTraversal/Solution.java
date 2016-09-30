package BTZigzagLevelOrderTraversal;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * Created by aoshen on 5/3/16.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (root == null) {
            return results;
        }

        Stack<TreeNode> leftToRight = new Stack<TreeNode>();
        Stack<TreeNode> rightToLeft = new Stack<TreeNode>();

        leftToRight.push(root);

        while (!leftToRight.empty() || !rightToLeft.empty()) {
            List<Integer> result = new ArrayList<Integer>();

            if (!leftToRight.empty()) {
                while (!leftToRight.empty()) {
                    TreeNode top = leftToRight.pop();

                    result.add(top.val);
                    if (top.left != null) {
                        rightToLeft.push(top.left);
                    }
                    if (top.right != null) {
                        rightToLeft.push(top.right);
                    }

                }
            } else {
                while (!rightToLeft.empty()) {
                    TreeNode top = rightToLeft.pop();

                    result.add(top.val);
                    if (top.right != null) {
                        leftToRight.push(top.right);
                    }
                    if (top.left != null) {
                        leftToRight.push(top.left);
                    }
                }
            }

            results.add(result);
        }

        return results;
    }
}
