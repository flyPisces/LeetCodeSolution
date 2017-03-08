package MinimumAbsoluteDifferenceinBST;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

 1
 \
 3
 /
 2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 Note: There are at least two nodes in this BST.

 * Created by aoshen on 3/4/17.
 */
public class Solution {
    Integer min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev));
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}
