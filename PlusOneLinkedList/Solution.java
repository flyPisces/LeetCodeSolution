package PlusOneLinkedList;

/**
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4

 * Created by aoshen on 7/27/16.
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode tailHead = reverseLinkedList(head);
        ListNode cur = tailHead;
        int borrow = 1;

        while (cur != null) {
            int sum = cur.val + borrow;
            cur.val = sum % 10;
            borrow = sum / 10;
            cur = cur.next;
        }

        cur = reverseLinkedList(tailHead);
        if (borrow == 1) {
            ListNode newhead = new ListNode(borrow);
            newhead.next = cur;

            return newhead;
        }

        return cur;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
