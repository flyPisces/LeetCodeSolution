package LinkedListComponents;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * We are given head, the head node of a linked list containing unique integer values.

 We are also given the list G, a subset of the values in the linked list.

 Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

 Example 1:

 Input:
 head: 0->1->2->3
 G = [0, 1, 3]
 Output: 2
 Explanation:
 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 Example 2:

 Input:
 head: 0->1->2->3->4
 G = [0, 3, 1, 4]
 Output: 2
 Explanation:
 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */
public class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }

        ListNode curr = head;
        int ans = 0;
        while (curr != null) {
            if (set.contains(curr.val) && (curr.next == null ||
                !set.contains(curr.next.val))) {
                ans ++;
            }
            curr = curr.next;

        }

        return ans;
    }
}
