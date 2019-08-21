package LCAofDeepestLeaves;

/**
 * Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.

 Recall that:

 The node of a binary tree is a leaf if and only if it has no children
 The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d+1.
 The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree with root A.


 Example 1:

 Input: root = [1,2,3]
 Output: [1,2,3]
 Explanation:
 The deepest leaves are the nodes with values 2 and 3.
 The lowest common ancestor of these leaves is the node with value 1.
 The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
 Example 2:

 Input: root = [1,2,3,4]
 Output: [4]
 Example 3:

 Input: root = [1,2,3,4,5]
 Output: [2,4,5]
 */
public class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0).node;
    }

    private Pair dfs(TreeNode root, int depth) {
        if (root == null) return new Pair(root, depth);

        Pair pLeft = dfs(root.left, depth + 1);
        Pair pRight = dfs(root.right, depth + 1);

        if (pLeft.depth == pRight.depth) {
            return new Pair(root, pLeft.depth);
        } else {
            return pLeft.depth > pRight.depth ? pLeft : pRight;
        }
    }
}

class Pair {
    int depth;
    TreeNode node;

    Pair(TreeNode node, int depth) {
        this.depth = depth;
        this.node = node;
    }
}
