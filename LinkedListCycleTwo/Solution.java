package LinkedListCycleTwo;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Created by aoshen on 4/16/16.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (slow == fast) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
