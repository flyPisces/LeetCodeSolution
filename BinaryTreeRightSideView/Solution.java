package BinaryTreeRightSideView;

import java.util.*;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].


 *
 * Created by aoshen on 5/28/16.
 */
public class Solution {

    private void dfs(int depth, TreeNode root, Map<Integer, Integer> depthToValMap) {
        if (root == null) {
            return;
        }

        depthToValMap.put(depth, root.val);
        dfs(depth + 1, root.left, depthToValMap);
        dfs(depth + 1, root.right, depthToValMap);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        int depth = 1;
        Map<Integer, Integer> depthToValMap = new HashMap<>();
        dfs(depth, root, depthToValMap);

        depth = 1;
        while (depthToValMap.containsKey(depth)) {
            results.add(depthToValMap.get(depth));
            depth ++;
        }
        return results;
    }
}
