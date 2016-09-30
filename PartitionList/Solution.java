package PartitionList;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode headOfBefore = new ListNode(0);
        ListNode curBefore = headOfBefore; 
        ListNode headOfAfter = new ListNode(0);
        ListNode curAfter = headOfAfter;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                curBefore.next = cur;
                curBefore = curBefore.next;
            } else {
                curAfter.next = cur;
                curAfter = curAfter.next;
            }
            cur = next;
        }
        
        curBefore.next = headOfAfter.next;
        return headOfBefore.next;
    }
}
