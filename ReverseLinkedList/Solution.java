package ReverseLinkedList;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            
            cur.next = null;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}
