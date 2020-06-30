package FlattenaMultilevelDoublyLinkedList;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 *
 */
public class Solution {
    public Node flatten(Node head) {
        helper(head);

        return head;
    }

    private Node helper(Node head) {
        Node curr = head, prev = head;

        while (curr != null) {
            if (curr.child == null) {
                prev = curr;
                curr = curr.next;
            } else {
                Node next = curr.next;

                Node endOfChild = helper(curr.child);

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;

                endOfChild.next = next;
                if (next != null) {
                    next.prev = endOfChild;}

                prev = endOfChild;
                curr = next;
            }
        }

        return prev;
    }
}
