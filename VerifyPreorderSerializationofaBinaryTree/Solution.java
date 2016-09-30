package VerifyPreorderSerializationofaBinaryTree;

import java.util.*;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

 _9_
 /   \
 3     2
 / \   / \
 4   1  #  6
 / \ / \   / \
 # # # #   # #
 For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

 Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

 Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

 You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

 Example 1:
 "9,3,4,#,#,1,#,#,2,#,6,#,#"
 Return true

 Example 2:
 "1,#"
 Return false

 Example 3:
 "9,#,#,1"
 Return false

 * Created by aoshen on 7/24/16.
 */
public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] splits = preorder.split(",");
        LinkedList<String> queue = new LinkedList<>();

        for (String node : splits) {
            queue.offer(node);

            while (queue.size() >= 3 &&
                    queue.get(queue.size() - 1).equals("#") &&
                    queue.get(queue.size() - 2).equals("#") &&
                    !queue.get(queue.size() - 3).equals("#")) {
                queue.remove(queue.size() - 1);
                queue.remove(queue.size() - 1);
                queue.remove(queue.size() - 1);

                queue.offer("#");
            }
        }

        if (queue.size() == 1 && queue.pop().equals("#")) {
            return true;
        }

        return false;
    }
}
