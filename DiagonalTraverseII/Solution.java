package DiagonalTraverseII;

import java.util.*;

/**
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
 */
public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int total = 0;
        Map<Integer, List<Integer>> levelMapping = new HashMap<>();
        int maxLevel = -1;

        for (int i = nums.size() - 1;i >= 0;-- i) {
            for (int j = 0;j < nums.get(i).size();++ j) {
                int index = i + j;

                levelMapping.putIfAbsent(index, new LinkedList<>());
                levelMapping.get(index).add(nums.get(i).get(j));
                ++ total;
                maxLevel = Math.max(maxLevel, index);
            }
        }

        int[] results = new int[total];
        int i = 0;

        for (int j = 0;j <= maxLevel;++ j) {
            for (int num : levelMapping.get(j)) {
                results[i ++] = num;
            }
        }

        return results;
    }
}
