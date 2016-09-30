package BTVerticalOrderTraversal;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:

 Given binary tree [3,9,20,null,null,15,7],
 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7],
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 return its vertical order traversal as:
 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 /\
 /  \
 5   2
 return its vertical order traversal as:
 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]

 * Created by aoshen on 7/27/16.
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (null == root) {
            return results;
        }

        LinkedList<TreeNode> levelNodes = new LinkedList<>();
        LinkedList<Integer> levels = new LinkedList<>();

        levelNodes.add(root);
        levels.add(0);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, List<Integer>> levelValues = new HashMap<>();

        while (!levelNodes.isEmpty()) {
            TreeNode cur = levelNodes.getFirst();
            Integer level = levels.getFirst();

            min = Math.min(min, level);
            max = Math.max(max, level);

            if (levelValues.containsKey(level)) {
                levelValues.get(level).add(cur.val);
            } else {
                List<Integer> nodeVals = new ArrayList<>();
                nodeVals.add(cur.val);
                levelValues.put(level, nodeVals);
            }

            if (cur.left != null) {
                levelNodes.add(cur.left);
                levels.add(level - 1);
            }

            if (cur.right != null) {
                levelNodes.add(cur.right);
                levels.add(level + 1);
            }

            levelNodes.poll();
            levels.poll();
        }

        for (int i = min;i <= max;++ i) {
            results.add(levelValues.get(i));
        }

        return results;
    }
}
