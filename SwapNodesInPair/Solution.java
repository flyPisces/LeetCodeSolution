package SwapNodesInPair;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * 
 * @author alshen
 *
 */

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode n1 = head;
        
        while (n1 != null && n1.next != null) {
            ListNode n2 = n1.next;
            ListNode next = n2.next;
            prev.next = n2;
            n2.next = n1;
            n1.next = next;
            
            prev = n1;
            n1 = next;
        }
        
        return dummy.next;
    }
}
