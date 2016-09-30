package ReorderList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode singleStep = head;
        ListNode doubleStep = head.next;
        
        while  (doubleStep.next != null && doubleStep.next.next != null) {
            singleStep = singleStep.next;
            doubleStep = doubleStep.next.next;
        }
        
        ListNode reverseHeadOfSecondHalf = reverseLinkedList(singleStep.next);
        singleStep.next = null;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = null;
        ListNode firstCur = head;
        ListNode secondCur = reverseHeadOfSecondHalf;
        
        while (firstCur != null && secondCur != null) {
            ListNode firstNext = firstCur.next;
            ListNode secondNext = secondCur.next;
            
            firstCur.next = null;
            secondCur.next = null;
            
            cur.next = firstCur;
            cur.next.next = secondCur;
            cur = cur.next.next;
            
            firstCur = firstNext;
            secondCur = secondNext;
        }
        
        if (firstCur != null) {
            cur.next = firstCur;
        }
        if (secondCur != null) {
            cur.next = secondCur;
        }
        
        head = dummy.next;
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
