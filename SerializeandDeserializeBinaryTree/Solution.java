package SerializeandDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

    For example, you may serialize the following tree

    1
    / \
    2   3
    / \
    4   5
    as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
    Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 *  Created by aoshen on 6/4/16.
 */
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);

        while (!list.isEmpty()) {
            TreeNode top = list.poll();

            if (top == null) {
                sb.append("null,");
            } else {
                sb.append(top.val + ",");
                list.add(top.left);
                list.add(top.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] splits = data.split(",");
        int size = splits.length;
        TreeNode[] nodes = new TreeNode[size];
        int[] nums = new int[size];

        for (int i = 0;i < size;++ i) {
            if (i > 0) {
                nums[i] = nums[i - 1];
            }

            if (splits[i].equals("null")) {
                nodes[i] = null;
                nums[i]++;
            } else {
                nodes[i] = new TreeNode(Integer.parseInt(splits[i]));
            }
        }

        for (int i = 0;i < size;++ i) {
            if (nodes[i] == null) {
                continue;
            }

            nodes[i].left = nodes[(i - nums[i]) * 2 + 1];
            nodes[i].right = nodes[(i - nums[i]) * 2 + 2];
        }


        return nodes[0];
    }
}
