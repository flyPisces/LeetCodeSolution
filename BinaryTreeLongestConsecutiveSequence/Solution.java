package BinaryTreeLongestConsecutiveSequence;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,
 1
 \
 3
 / \
 2   4
 \
 5
 Longest consecutive sequence path is 3-4-5, so return 3.
 2
 \
 3
 /
 2
 /
 1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

 * Created by aoshen on 6/28/16.
 */
public class  Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root, 0, root.val - 1);
    }

    private int helper(TreeNode root, int len, int preVal) {
        if (root == null) {
            return len;
        }

        int currLen = preVal + 1 ==root.val ? len + 1 : 1;
        return Math.max(currLen, Math.max(helper(root.left, currLen, root.val), helper(root.right, currLen, root.val)));
    }
}
