package ArrayTransformation;

import java.util.*;

/**
 * Given an initial array arr, every day you produce a new array using the array of the previous day.
 *
 * On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:
 *
 * If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
 * If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
 * The first and last elements never change.
 * After some days, the array does not change. Return that final array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [6,2,3,4]
 * Output: [6,3,3,4]
 * Explanation:
 * On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
 * No more operations can be done to this array.
 * Example 2:
 *
 * Input: arr = [1,6,3,4,3,5]
 * Output: [1,4,4,4,4,5]
 * Explanation:
 * On the first day, the array is changed from [1,6,3,4,3,5] to [1,5,4,3,4,5].
 * On the second day, the array is changed from [1,5,4,3,4,5] to [1,4,4,4,4,5].
 * No more operations can be done to this array.
 */
public class Solution {
    public List<Integer> transformArray(int[] arr) {
        List<Integer> results = new ArrayList<>();

        int[] ans = new int[arr.length];
        while (!Arrays.equals(ans, arr)) {
            ans = arr.clone();
            for (int i = 1;i < arr.length - 1;++ i) {
                if (ans[i - 1] < ans[i] && ans[i] > ans[i + 1]) {
                    --arr[i];
                } else if (ans[i - 1] > ans[i] && ans[i] < ans[i + 1]) {
                    ++arr[i];
                }
            }
        }

        for (int num : ans) {
            results.add(num);
        }

        return results;
    }
}
