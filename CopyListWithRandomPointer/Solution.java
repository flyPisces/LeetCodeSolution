package CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.*;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
 *
 * Created by aoshen on 4/16/16.
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (null == head) {
            return null;
        }

        RandomListNode oldCur = head;
        RandomListNode newHead = null;
        RandomListNode newCur = null;
        Map<RandomListNode, RandomListNode> oldToNewMap = new HashMap();

        while (oldCur != null) {
            if (newHead == null) {
                newHead = new RandomListNode(oldCur.label);
                newCur = newHead;
            } else {
                newCur.next = new RandomListNode(oldCur.label);
                newCur = newCur.next;
            }

            oldToNewMap.put(oldCur, newCur);
            oldCur = oldCur.next;
        }

        oldCur = head;
        newCur = newHead;

        while (oldCur != null) {
            newCur.random = oldToNewMap.get(oldCur.random);
            newCur = newCur.next;
            oldCur = oldCur.next;
        }

        return newHead;
    }
}
