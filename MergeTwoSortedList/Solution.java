package MergeTwoSortedList;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 */



public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = null;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur = l1;
                l1 = l1.next;
            } else {
                cur = l2;
                l2 = l2.next;
            }
            
            prev.next = cur;
            prev = cur;
        }
        
        if (l1 != null) {
            prev.next = l1;
        }
        
        if (l2 != null) {
            prev.next = l2;
        }
        
        return dummy.next;
    }
}
