package DeleteNodesAndReturnForest;

import java.util.*;

public class Solution {
    Set<Integer> deletes = new HashSet<>();
    List<TreeNode> results = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int delete : to_delete) {
            deletes.add(delete);
        }

        dfs(root, true);

        return results;
    }

    private TreeNode dfs(TreeNode root, boolean isRoot) {
        if (null == root) return null;

        boolean is_delete = false;
        if (deletes.contains(root.val)) is_delete = true;
        if (isRoot && !is_delete) results.add(root);

        root.left = dfs(root.left, is_delete);
        root.right = dfs(root.right, is_delete);

        return is_delete ? null : root;
    }
}
