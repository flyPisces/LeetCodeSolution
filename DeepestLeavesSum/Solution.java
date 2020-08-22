package DeepestLeavesSum;

import java.util.*;

/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 */
public class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);

        int result = 0;

        while (!list.isEmpty()) {
            result = 0;
            int size = list.size();

            for (int i = 0;i < size;++ i) {
                TreeNode node = list.poll();
                result +=  node.val;

                if (node.left != null) list.offer(node.left);
                if (node.right != null) list.offer(node.right);
            }
        }

        return result;
    }
}
