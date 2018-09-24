package MaximumFrequencyStack;

import java.util.*;

/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.

 FreqStack has two functions:

 push(int x), which pushes an integer x onto the stack.
 pop(), which removes and returns the most frequent element in the stack.
 If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.


 Example 1:

 Input:
 ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 Output: [null,null,null,null,null,null,null,5,7,5,4]
 Explanation:
 After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

 pop() -> returns 5, as 5 is the most frequent.
 The stack becomes [5,7,5,7,4].

 pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 The stack becomes [5,7,5,4].

 pop() -> returns 5.
 The stack becomes [5,7,4].

 pop() -> returns 4.
 The stack becomes [5,7].
 The stack becomes [5,7].
 */
public class FreqStack {
    Map<Integer, Integer> keyCount;
    Map<Integer, Stack<Integer>> countKeys;
    int maxFreq = 0;

    public FreqStack() {
        keyCount = new HashMap<>();
        countKeys = new HashMap<>();
    }

    public void push(int x) {
        int freq = keyCount.getOrDefault(x, 0) + 1;
        maxFreq = Math.max(freq, maxFreq);
        if (!countKeys.containsKey(freq)) {
            countKeys.put(freq, new Stack<>());
        }
        keyCount.put(x, freq);
        countKeys.get(freq).add(x);
    }

    public int pop() {
        int res = countKeys.get(maxFreq).pop();
        if (countKeys.get(maxFreq).isEmpty()) {
            maxFreq --;
        }

        keyCount.put(res, keyCount.get(res) - 1);
        return res;
    }
}
