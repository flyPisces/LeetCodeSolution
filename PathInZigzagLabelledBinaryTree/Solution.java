package PathInZigzagLabelledBinaryTree;

import java.util.*;

/**
 * In an infinite binary tree where every node has two children, the nodes are labelled in row order.

 In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right, while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.

 Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.



 Example 1:

 Input: label = 14
 Output: [1,3,4,14]
 Example 2:

 Input: label = 26
 Output: [1,2,6,10,26]
 */
public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int level = 0;

        while (1 << level <= label) ++ level;

        for (;label >= 1;label /= 2, -- level) {
            list.add( 0, label);
            label = (1 << level) - 1 - label + (1 << (level - 1));
        }

        return list;
    }
}
