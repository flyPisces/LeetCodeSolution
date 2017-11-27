package MostFrequentSubtreeSum;

import java.util.*;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
 * (including the node itself).
 *
 * So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.

 Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.
 Examples 2
 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 * Created by aoshen on 2/7/17.
 */
public class Solution {
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (null == root) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> res = new LinkedList<>();
        for(Map.Entry<Integer, Integer> me: map.entrySet()){
            if(me.getValue()==max) res.add(me.getKey());
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    private int helper(TreeNode root, Map<Integer, Integer> map) {
        int left = (root.left == null) ? 0 : helper(root.left, map);
        int right = (root.right == null) ? 0 : helper(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0 ) + 1);
        max = Math.max(max, map.get(sum));
        return sum;

    }
}
