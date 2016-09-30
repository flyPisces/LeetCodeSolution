package LinkedListCycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode singleStep = head;
        ListNode doubleStep = head.next;
        
        while (singleStep != null && doubleStep != null) {
            if (singleStep == doubleStep) {
                return true;
            }
            singleStep = singleStep.next;
            if (doubleStep.next == null) {
                break;
            } else {
                doubleStep = doubleStep.next.next;
            }
            
        }
        
        return false;
    }
}
