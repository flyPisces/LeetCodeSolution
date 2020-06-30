package ConvertBinaryNumberinaLinkedListtoInteger;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;

        while (head != null) {
            ans = (ans << 1) | (head.val & 1);
            head = head.next;
        }

        return ans;
    }
}
