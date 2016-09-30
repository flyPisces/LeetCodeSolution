package TopKFrequentElements;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * Created by aoshen on 6/1/16.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> mapping = new HashMap<>();
        for (int num : nums) {
            if (mapping.containsKey(num)) {
                mapping.put(num, mapping.get(num) + 1);
            } else {
                mapping.put(num, 1);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
        for (int i = 1;i <= max;++ i) {
            arr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            Integer key = entry.getKey();
            Integer times = entry.getValue();

            arr[times].add(key);
        }

        for (int i = max;i >= 0;-- i) {
            for (Integer key : arr[i]) {
                if (result.size() < k) {
                    result.add(key);
                } else {
                    break;
                }
            }

            if (result.size() == k) {
                break;
            }
        }

        return result;
    }
}
