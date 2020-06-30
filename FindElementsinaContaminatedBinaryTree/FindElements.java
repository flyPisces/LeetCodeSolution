package FindElementsinaContaminatedBinaryTree;

import sun.tools.jconsole.inspector.XNodeInfo;

import java.util.*;

/**
 *
 Given a binary tree with the following rules:

 root.val == 0
 If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
 If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
 Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

 You need to first recover the binary tree and then implement the FindElements class:

 FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
 bool find(int target) Return if the target value exists in the recovered binary tree.
 */
public class FindElements {
    Set<Integer> elements = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode root, int v) {
        if (root == null) return;

        elements.add(v);
        root.val = v;

        dfs(root.left, 2 * v + 1);
        dfs(root.right, 2 * v + 2);
    }

    public boolean find(int target) {
        return elements.contains(target);
    }
}
