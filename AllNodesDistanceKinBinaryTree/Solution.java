package AllNodesDistanceKinBinaryTree;

import java.util.*;

/**
 *
 We are given a binary tree (with root node root), a target node, and an integer value `K`.

 Return a list of the values of all nodes that have a distance K from the target node.

 The answer can be returned in any order.

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 Output: [7,4,1]
 Explanation:
 The nodes that are a distance 2 from the target node (with value 5)
 have values 7, 4, and 1.
 */
public class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMapping = new HashMap<>();
        dfs(parentMapping, null, root);

        Queue<TreeNode> list = new LinkedList<>();
        list.add(null);
        list.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        visited.add(null);

        int dist = 0;
        while (!list.isEmpty()) {
            TreeNode top = list.poll();

            if (top == null) {
                if (dist == K) {
                    List<Integer> result = new ArrayList<>();
                    for (TreeNode node : list) {
                        result.add(node.val);
                    }

                    return result;
                }
                dist ++;
                list.offer(null); 

            } else {
                if (!visited.contains(top.left)) {
                    list.offer(top.left);
                    visited.add(top.left);
                }

                if (!visited.contains(top.right)) {
                    list.offer(top.right);
                    visited.add(top.right);
                }

                if (!visited.contains(parentMapping.get(top))) {
                    list.offer(parentMapping.get(top));
                    visited.add(parentMapping.get(top));
                }
            }
        }

        return new ArrayList<Integer>();
    }

    private void dfs(Map<TreeNode, TreeNode> parentMapping, TreeNode parent, TreeNode child) {
        if (child != null) {
            parentMapping.put(child, parent);
            dfs(parentMapping, child, child.left);
            dfs(parentMapping, child, child.right);
        }
    }
}
