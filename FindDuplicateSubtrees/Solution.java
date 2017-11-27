package FindDuplicateSubtrees;

import java.util.*;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees,
 * you only need to return the root node of any one of them.

 Two trees are duplicate if they have the same structure with same node values.

 Example 1:
 1
 / \
 2   3
 /   / \
 4   2   4
 /
 4
 The following are two duplicate subtrees:
 2
 /
 4
 and
 4
 Therefore, you need to return above trees' root in the form of a list.

 * Created by aoshen on 7/30/17.
 */
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = postorder(cur.left, map, res) + "," + postorder(cur.right, map, res) + "," + cur.val;
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
