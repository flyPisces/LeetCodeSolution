package NaryTreeLevelOrderTraversal;

import java.util.*;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) return results;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> result = new ArrayList<>();
            for (int i = 0;i < size;++ i) {
                Node curr = queue.poll();
                result.add(curr.val);

                if (curr.children != null) {
                    for (Node node : curr.children) {
                        queue.offer(node);
                    }
                }
            }

            results.add(result);
        }

        return results;
    }
}
