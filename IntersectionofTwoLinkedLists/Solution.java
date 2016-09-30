package IntersectionofTwoLinkedLists;

import java.util.*;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 * Created by aoshen on 7/10/16.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        ListNode shorter = headA;
        ListNode longer = headB;

        if (lenA > lenB) {
            shorter = headB;
            longer = headA;
        }

        int diff = Math.abs(lenA - lenB);
        for (int i = 0;i < diff;++ i) {
            longer = longer.next;
        }

        while (longer != null && shorter != null) {
            if (longer.val == shorter.val) {
                return longer;
            }

            longer = longer.next;
            shorter = shorter.next;
        }

        return null;
    }

    private int getListLength(ListNode headA) {
        int len = 0;

        ListNode cur = headA;
        while (cur != null) {
            ++ len;
            cur = cur.next;
        }

        return len;
    }
}
