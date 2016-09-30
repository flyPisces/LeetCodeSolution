package AddTwoNumbers;


/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

public class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode beginner = null;
        ListNode cur = null;
        
        if (l1 == null)
        {
            return l2;
        }
        else if (l2 == null)
        {
            return l1;
        }
        else
        {
            int borrow = 0;
            int sum = 0;
            
            while(l1 != null && l2 != null)
            {
                if (beginner == null)
                {
                    sum = l1.val + l2.val + borrow;
                    beginner = new ListNode(sum % 10);
                    borrow = sum / 10;
                    cur = beginner;
                }
                else
                {
                    sum = l1.val + l2.val + borrow;
                    cur.next = new ListNode(sum % 10);
                    borrow = sum / 10;
                    cur = cur.next;
                }
                
                l1 = l1.next;
                l2 = l2.next;
            }
            
            while(l1 != null)
            {
                sum = l1.val + borrow;
                cur.next = new ListNode(sum % 10);
                borrow = sum / 10;
                cur = cur.next;
                l1 = l1.next;
            }
            
            while(l2 != null)
            {
                sum = l2.val + borrow;
                cur.next = new ListNode(sum % 10);
                borrow = sum / 10;
                cur = cur.next;   
                l2 = l2.next;
            }
            
            if (borrow != 0)
            {
                cur.next = new ListNode(borrow);
                cur = cur.next;
            }
        }
        
        return beginner;
    }
}
