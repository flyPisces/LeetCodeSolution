package TwoSumFourBST;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 9

 Output: True
 Example 2:
 Input:
 5
 / \
 3   6
 / \   \
 2   4   7

 Target = 28

 Output: False

 * Created by aoshen on 8/8/17.
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> vals = new HashSet<>();

        return dfs(root, vals, k);
    }

    public boolean dfs(TreeNode root, Set<Integer> vals, int k) {
        if (null == root) return false;

        if (vals.contains(k - root.val)) return true;
        vals.add(root.val);

        return dfs(root.left, vals, k) || dfs(root.right, vals, k);
    }
}
