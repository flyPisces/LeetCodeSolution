package RemoveDuplicatesFromSortedListTwo;

/** 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    For example,
    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.
 *
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode n1 = dummy;
        
        while (n1.next != null) {
            ListNode n2 = n1.next;
            
            while (n2.next != null && n2.val == n2.next.val) {
                n2 = n2.next;
            }
            
            if (n2 != n1.next) {
                n1.next = n2.next;
            } else {
                n1 = n2;
            }
        }
        
        return head.next;
    }
}
