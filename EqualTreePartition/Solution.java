package EqualTreePartition;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.

 Example 1:
 Input:
 5
 / \
 10 10
 /  \
 2   3

 Output: True
 Explanation:
 5
 /
 10

 Sum: 15

 10
 /  \
 2    3

 Sum: 15
 Example 2:
 Input:
 1
 / \
 2  10
 /  \
 2   20

 Output: False
 Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the

 * Created by aoshen on 8/21/17.
 */
public class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> mapping = new HashMap<>();
        int sum = getSum(mapping, root);
        if (sum == 0) return mapping.getOrDefault(sum, 0) > 1;

        return sum % 2 == 0 && mapping.containsKey(sum / 2);
    }

    private int getSum(Map<Integer, Integer> mapping, TreeNode root) {
        if (null == root) return 0;

        int sum = root.val + getSum(mapping, root.left) + getSum(mapping, root.right);
        mapping.put(sum, mapping.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
