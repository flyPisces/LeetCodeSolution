package SubtreeofAnotherTree;

import java.util.*;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 Given tree t:
 4
 / \
 1   2
 Return true, because t has the same structure and node values with a subtree of s.
 Example 2:
 Given tree s:

 3
 / \
 4   5
 / \
 1   2
 /
 0
 Given tree t:
 4
 / \
 1   2


 * Created by aoshen on 5/9/17.
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sPreOrder = generatePostOrder(s);
        String tPreOrder = generatePostOrder(t);

        return sPreOrder.contains(tPreOrder);
    }

    public String generatePostOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode peekItem = st.pop();

            if (peekItem == null) {
                sb.append(",#");
            } else {
                sb.append("," + peekItem.val);
            }

            if (peekItem != null) {
                st.push(peekItem.right);
                st.push(peekItem.left);
            }
        }

        return sb.toString();
    }
}
