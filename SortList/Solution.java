package SortList;

import java.util.spi.LocaleServiceProvider;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Created by aoshen on 5/1/16.
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode faster = head;

        while (faster.next != null && faster.next.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = (slow != null ? slow.next : null);
        slow.next = null;

        if (firstHalf != secondHalf) {
            firstHalf = sortList(firstHalf);
            secondHalf = sortList(secondHalf);
        }

        return mergeTwoParts(firstHalf, secondHalf);
    }

    public ListNode mergeTwoParts(ListNode firstHalf, ListNode secondHalf) {
        ListNode newHead = new ListNode(0);

        if (secondHalf == null) {
            return firstHalf;
        }

        if (firstHalf == null) {
            return secondHalf;
        }

        ListNode cur = newHead;
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val <= secondHalf.val) {
                cur.next = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                cur.next = secondHalf;
                secondHalf = secondHalf.next;
            }

            cur = cur.next;
        }

        if (firstHalf != null) {
            cur.next = firstHalf;
        }

        if (secondHalf != null) {
            cur.next = secondHalf;
        }

        return newHead.next;
    }
}
