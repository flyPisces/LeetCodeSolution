package HandofStraights;

import java.util.PriorityQueue;

/**
 *
 Alice has a hand of cards, given as an array of integers.

 Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

 Return true if and only if she can.



 Example 1:

 Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 Output: true
 Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 Example 2:

 Input: hand = [1,2,3,4,5], W = 4
 Output: false
 Explanation: Alice's hand can't be rearranged into groups of 4.
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int N = hand.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : hand) {
            pq.add(num);
        }

        while (!pq.isEmpty()) {
            int top = pq.poll();

            for (int i = 1;i < W;++ i) {
                if (pq.remove(top + i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
