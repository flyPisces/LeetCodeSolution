package ConvertSortedListtoBinarySearchTree;

/**
 * Created by aoshen on 5/2/16.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;

        if (head == null) {
            return root;
        }

        if (head.next == null) {
            root = new TreeNode(head.val);
            return root;
        }

        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        root = new TreeNode(slow.val);
        root.left = slow == head ? null : sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}

