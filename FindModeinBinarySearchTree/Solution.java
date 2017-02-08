package FindModeinBinarySearchTree;

import java.util.*;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
 1
 \
 2
 /
 2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

 * Created by aoshen on 1/31/17.
 */
public class Solution {
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (null == root) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0;i < list.size();++ i) res[i] = list.get(i);

        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (null == root) return;
        traverse(root.left, list);

        if (prev != null) {
            if (prev == root.val) {
                count ++;
            } else {
                count = 1;
            }
        }

        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }

        prev = root.val;
        traverse(root.right, list);
    }
}
