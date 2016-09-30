package PathSumTwo;

import java.util.*;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 * Created by aoshen on 9/4/16.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return results;
        }

        result.add(root.val);
        helper(root, sum - root.val, results, result);

        return results;
    }

    public void helper(TreeNode root, int sum, List<List<Integer>> results, List<Integer> result) {
        if (root.left == null && root.right == null && sum == 0) {
            results.add(new ArrayList<>(result));
            return;
        }

        if (root.left != null) {
            result.add(root.left.val);
            helper(root.left, sum - root.left.val, results, result);
            result.remove(result.size() - 1);
        }

        if (root.right != null) {
            result.add(root.right.val);
            helper(root.right, sum - root.right.val, results, result);
            result.remove(result.size() - 1);
        }
    }
}
