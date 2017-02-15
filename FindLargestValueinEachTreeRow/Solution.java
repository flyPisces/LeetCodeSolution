package FindLargestValueinEachTreeRow;

import java.util.*;

/**
 * ou need to find the largest value in each row of a binary tree.

 Example:
 Input:

 1
 / \
 3   2
 / \   \
 5   3   9

 Output: [1, 3, 9]

 * Created by aoshen on 2/13/17.
 */
public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> levelMaxMapping = new HashMap<>();

        helper(root, levelMaxMapping, 1);

        if (levelMaxMapping.size() == 0) {
            return new ArrayList<>();
        }

        int size = levelMaxMapping.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0;i < size;++ i) {
            results.add(levelMaxMapping.get(i + 1));
        }

        return results;
    }

    private void helper(TreeNode root, Map<Integer, Integer> levelMaxMapping, int depth) {
        if (root == null) return;

        if (levelMaxMapping.containsKey(depth)) {
            levelMaxMapping.put(depth, Math.max(levelMaxMapping.get(depth), root.val));
        } else {
            levelMaxMapping.put(depth, root.val);
        }

        helper(root.left, levelMaxMapping, depth + 1);
        helper(root.right, levelMaxMapping, depth + 1);
    }
}
