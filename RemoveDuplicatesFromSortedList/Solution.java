package RemoveDuplicatesFromSortedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author alshen
 */


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        Integer last = head.val;
        
        while (cur.next != null) {
            if (cur.next.val == last) {
                ListNode next = cur.next.next;
                cur.next = next;
            } else {
                last = cur.next.val;
                cur = cur.next;
            }
        }
           
        return dummy.next;
    }
}
