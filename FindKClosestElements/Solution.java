package FindKClosestElements;

import java.util.*;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]

 * Created by aoshen on 8/16/17.
 */
public class Solution {
    int findCrossOver(List<Integer> arr, int low, int high, int x) {
        if (arr.get(high) <= x) return high;
        if (arr.get(low) > x)  return low;

        int mid = low + (high - low)/2;

        if (arr.get(mid) <= x && arr.get(mid+1) > x) return mid;

        if(arr.get(mid) < x) return findCrossOver(arr, mid+1, high, x);
        return findCrossOver(arr, low, mid - 1, x);
    }

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        int l = findCrossOver(arr, 0, arr.size() - 1, x);
        int r = l + 1;
        int count = 0;

        while (l >= 0 && r < arr.size() && count < k) {
            if (x - arr.get(l) <= arr.get(r) - x) res.add(arr.get(l--));
            else res.add(arr.get(r++));
            count++;
        }

        while (count < k && l >= 0) {
            res.add(arr.get(l--));
            count++;
        }
        while (count < k && r < arr.size()) {
            res.add(arr.get(r++));
            count++;
        }

        Collections.sort(res);
        return res;
    }
}
