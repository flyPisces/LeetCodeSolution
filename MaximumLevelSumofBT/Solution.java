package MaximumLevelSumofBT;

import java.util.*;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

 Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

 Input: [1,7,0,7,-8,null,null]
 Output: 2
 Explanation:
 Level 1 sum = 1.
 Level 2 sum = 7 + 0 = 7.
 Level 3 sum = 7 + -8 = -1.
 So we return the level with the maximum sum which is level 2.

 */

public class Solution {
    public int maxLevelSum(TreeNode root) {

        if (null == root) return 0;

        int results = -1, level = 1, maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> levels = new LinkedList<>();
        levels.offer(root);

        while (!levels.isEmpty()) {
            int sum = 0, size = levels.size();

            for (int i = 0;i < size;++ i) {
                TreeNode curr = levels.poll();

                sum += curr.val;

                if (curr.left != null) {
                    levels.offer(curr.left);
                }

                if (curr.right != null) {
                    levels.offer(curr.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                results = level;
            }

            level ++;
        }

        return results;
    }
}
