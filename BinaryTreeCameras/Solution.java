package BinaryTreeCameras;

import java.util.*;

/**
 *
 Given a binary tree, we install cameras on the nodes of the tree.

 Each camera at a node can monitor its parent, itself, and its immediate children.

 Calculate the minimum number of cameras needed to monitor all nodes of the tree.


 */
public class Solution {

    int result = 0;
    Set<TreeNode> set = new HashSet<>();

    public int minCameraCover(TreeNode root) {
        set.add(null);
        dfs(root, null);
        return result;
    }

    private void dfs(TreeNode root, TreeNode parent) {
        if (root != null) {
            dfs(root.left, root);
            dfs(root.right, root);

            if ((parent == null && !set.contains(root)) ||
                    !set.contains(root.left) ||
                    !set.contains(root.right)) {
                result ++;
                set.add(parent);
                set.add(root);
                set.add(root.left);
                set.add(root.right);
            }
        }
    }
}
