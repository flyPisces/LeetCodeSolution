package CheckCompletenessofaBT;

import java.util.*;

/**
 * Given a binary tree, determine if it is a complete binary tree.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (bfs.peek() != null) {
            TreeNode top = bfs.poll();
            bfs.add(top.left);
            bfs.add(top.right);
        }

        while (!bfs.isEmpty() && bfs.peek() == null) {
            bfs.poll();
        }

        return bfs.isEmpty();
    }
}
