package ArrayofDoubledPairs;

import java.util.*;

/**
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.



 Example 1:

 Input: [3,1,3,6]
 Output: false
 Example 2:

 Input: [2,1,2,6]
 Output: false
 Example 3:

 Input: [4,-2,2,-4]
 Output: true
 Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 Example 4:

 Input: [1,2,4,16,8,4]
 Output: false
 */
public class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= 0) continue;
            int key = entry.getKey();
            int wanted = key < 0 ? key / 2 : 2 * key;

            if (key < 0 && key % 2 == 1 || map.get(key) > map.getOrDefault(wanted, 0)) {
                return false;
            }

            map.put(wanted, map.getOrDefault(wanted, 0) - map.get(key));
        }

        return true;
    }
}
