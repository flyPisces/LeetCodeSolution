package ConfusingNumberII;

import java.util.HashMap;
import java.util.Map;

/**
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 *
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)
 *
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 * Example 2:
 *
 * Input: 100
 * Output: 19
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 */
public class Solution {
    int result = 0;

    public int confusingNumberII(int N) {
        Map<Integer, Integer> mapping = new HashMap<>();

        mapping.put(0, 0);
        mapping.put(1, 1);
        mapping.put(6, 9);
        mapping.put(9, 6);
        mapping.put(8, 8);

        dfs(N, mapping, 0);

        return result;
    }

    private void dfs(int N, Map<Integer, Integer> mapping, long original) {
        if (isConfusingNumber(original, mapping)) result ++;

        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            if (original * 10 + entry.getKey() <= N && original * 10 + entry.getKey() > 0) {
                dfs(N, mapping, original * 10 + entry.getKey());
            }
        }
    }

    private boolean isConfusingNumber(long original, Map<Integer, Integer> mapping) {
        long res = 0;
        long src = original;

        while (original > 0) {
            res = res * 10 + mapping.get((int)original % 10);
            original /= 10;
        }

        return res != src;
    }
}
