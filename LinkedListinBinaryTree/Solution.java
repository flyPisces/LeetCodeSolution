package LinkedListinBinaryTree;

import java.util.List;

/**
 * Given a binary tree root and a linked list with head as the first node.
 *
 * Return True if all the elements in the linked list starting from the head correspond to some downward path connected in the binary tree otherwise return False.
 *
 * In this context downward path means a path that starts at some node and goes downwards.
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        return root.val == head.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}
