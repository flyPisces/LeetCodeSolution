package ReverseNodesInKGroup;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 *
 * Created by aoshen on 5/2/16.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;

        int num = 1;
        while (cur != null) {

            if (num % k == 0) {
                pre = reverseKNodes(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
            ++ num;
        }

        return fakeHead.next;
    }

    public ListNode reverseKNodes(ListNode pre, ListNode next) {
        ListNode first = pre.next;
        pre.next = null;

        ListNode kthPre = null;
        ListNode cur = first;

        while (cur != next) {
            ListNode kthNext = cur.next;
            cur.next = kthPre;
            kthPre = cur;
            cur = kthNext;
        }

        pre.next = kthPre;
        first.next = next;

        return first;
    }
}
