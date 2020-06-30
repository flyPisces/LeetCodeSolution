package ConvertBinarySearchTreetoSortedDoublyLinkedList;

import javax.print.attribute.standard.NumberUp;

/**
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
 *
 * You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
 *
 * We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.
 */

public class Solution {
    Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;

        dfs(root);

        prev.right = dummy.right;
        dummy.right.left = prev;

        return dummy.right;
    }

    private void dfs(Node root) {
        if (null == root) return;

        dfs(root.left);

        prev.right = root;
        root.left = prev;

        prev = root;

        dfs(root.right);
    }
}
