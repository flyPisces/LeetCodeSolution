package SmallestStringStartingFromLeaf;

/**
 * Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

 Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

 (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 */
public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root);
    }

    private String dfs(TreeNode root) {
        if (null == root) return "";

        String left = dfs(root.left);
        String right = dfs(root.right);

        if (left.length() > 0 && right.length() > 0) {
            return ((left.compareTo(right) < 0) ? left : right) + (char)('a' + root.val);
        } else if (left.length() > 0) {
            return left + (char)('a' + root.val);
        } else if (right.length() > 0) {
            return right + (char)('a' + root.val);
        } else {
            return "" + (char)('a' + root.val);
        }
    }
}
