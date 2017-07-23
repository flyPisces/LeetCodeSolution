package BTLongestConsecutiveSequenceTwo;

/**
 * Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

 Especially, this path can be either increasing or decreasing.
 For example, [1,2,3,4] and [4,3,2,1] are both considered valid,
 but the path [1,2,4,3] is not valid. On the other hand,
 the path can be in the child-Parent-child order, where not necessarily be parent-child order.

 Example 1:
 Input:
 1
 / \
 2   3
 Output: 2
 Explanation: The longest consecutive path is [1, 2] or [2, 1].
 Example 2:
 Input:
 2
 / \
 1   3
 Output: 3
 Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].

 * Created by aoshen on 4/14/17.
 */
public class Solution {
    int maxval = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return maxval;
    }
    public int[] longestPath(TreeNode root) {
        if (root == null)
            return new int[] {0,0};
        int inr = 1, dcr = 1;
        if (root.left != null) {
            int[] l = longestPath(root.left);
            if (root.val == root.left.val + 1)
                dcr = l[1] + 1;
            else if (root.val == root.left.val - 1)
                inr = l[0] + 1;
        }
        if (root.right != null) {
            int[] r = longestPath(root.right);
            if (root.val == root.right.val + 1)
                dcr = Math.max(dcr, r[1] + 1);
            else if (root.val == root.right.val - 1)
                inr = Math.max(inr, r[0] + 1);
        }
        maxval = Math.max(maxval, dcr + inr - 1);
        return new int[] {inr, dcr};
    }
}
