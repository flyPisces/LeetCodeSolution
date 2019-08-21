package ConfusingNumber;

import java.util.*;

/**
 * Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:

 We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid. A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.

 Input: 6
 Output: true
 Explanation:
 We get 9 after rotating 6, 9 is a valid number and 9!=6.
 */
public class Solution {
    public boolean confusingNumber(int N) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        int newNum = 0;
        int x = N;
        while (x != 0) {
            int remainder = x % 10;
            if (!map.containsKey(remainder))
                return false;
            newNum = newNum * 10 + map.get(remainder);
            x /= 10;
        }
        return N == newNum? false: true;
    }
}
