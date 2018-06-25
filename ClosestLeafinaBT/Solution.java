package ClosestLeafinaBT;

import java.util.*;

/**
 * Given a binary tree where every node has a unique value, and a target key k,
 * find the value of the closest leaf node to target k in the tree.

 Here, closest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree.
 Also, a node is called a leaf if it has no children.

 In the following examples, the input tree is represented in flattened form row by row.
 The actual root tree given will be a TreeNode object.

 Example 1:

 Input:
 root = [1, 3, 2], k = 1
 Diagram of binary tree:
 1
 / \
 3   2

 Output: 2 (or 3)

 Explanation: Either 2 or 3 is the closest leaf node to the target of 1.
 Example 2:

 Input:
 root = [1], k = 1
 Output: 1

 Explanation: The closest leaf node is the root node itself.
 Example 3:

 Input:
 root = [1,2,3,4,null,null,null,5,null,6], k = 2
 Diagram of binary tree:
 1
 / \
 2   3
 /
 4
 /
 5
 /
 6

 Output: 3
 Explanation: The leaf node with value 3 (and not the leaf node with value 6) is closest to the node with value 2.
 */
public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = Integer.MAX_VALUE, kval = -1;

    public int findClosestLeaf(TreeNode root, int k) {
        helper(root, k);
        map.put(k, 0);
        find(root, -1);
        return kval;
    }

    public void find(TreeNode root, int pos) {
        if (null == root) return;

        if (map.containsKey(root.val)) {
            pos = map.get(root.val);
        }

        if (root.left == null && root.right == null) {
            if (pos < ans) {
                ans = pos;
                kval = root.val;
                return;
            }
        }

        if (root.left != null) find(root.left, pos + 1);
        if (root.right != null) find(root.right, pos + 1);
    }

    public int helper(TreeNode root, int k) {
        if (null == root) return -1;
        if (root.val == k) {
            return 1;
        }

        int val = helper(root.left, k);
        if (val != -1) {
            map.put(root.val, val);
            return val + 1;
        }
        val = helper(root.right, k);
        if (val != -1) {
            map.put(root.val, val);
            return val + 1;
        }
        return -1;
    }
}
