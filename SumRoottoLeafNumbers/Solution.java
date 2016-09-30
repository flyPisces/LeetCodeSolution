package SumRoottoLeafNumbers;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 *
 * Created by aoshen on 5/12/16.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    public int sumNumbersHelper(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return level + root.val;
        }

        int nextLevelBase = 10 * (root.val + level);
        int leftSubTreeSum = sumNumbersHelper(root.left, nextLevelBase);
        int rightSubTreeSum = sumNumbersHelper(root.right, nextLevelBase);

        return leftSubTreeSum + rightSubTreeSum;
    }
}
