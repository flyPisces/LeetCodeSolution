package AllElementsinTwoBST;

import java.util.*;

/**
 * Given two binary search trees root1 and root2.
 *
 * Return a list containing all the integers from both trees sorted in ascending order.
 *
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 *
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 *
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * Example 4:
 *
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * Example 5:
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> results = new ArrayList<>();

        while (!list1.isEmpty() || !list2.isEmpty()) {
            if (list1.isEmpty()) {
                results.add(list2.pollFirst());
            } else if (list2.isEmpty()) {
                results.add(list1.pollFirst());
            } else {
                if (list1.peekFirst() < list2.peekFirst()) {
                    results.add(list1.pollFirst());
                } else {
                    results.add(list2.pollFirst());
                }
            }
        }

        return results;
    }

    private void inorder(TreeNode root, LinkedList<Integer> order) {
        if (null == root) return;
        inorder(root.left, order);
        order.add(root.val);
        inorder(root.right, order);
    }
}
