package FindLeavesofBinaryTree;

import java.util.*;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:

 1
 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].

 * Created by aoshen on 8/2/16.
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        dfsHelper(results, root);
        return results;
    }

    private int dfsHelper(List<List<Integer>> results, TreeNode root) {
        if (root == null) {
            return -1;
        }

        int left = dfsHelper(results, root.left);
        int right = dfsHelper(results, root.right);

        int height = Math.max(left, right) + 1;

        if (height >= results.size()) {
            results.add(new ArrayList<Integer>());
        }

        results.get(height).add(root.val);
        return height;
    }
}
