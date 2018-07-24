package SmallestSubtreewithalltheDeepestNodes;

/**
 * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

 A node is deepest if it has the largest depth possible among any node in the entire tree.

 The subtree of a node is that node, plus the set of all descendants of that node.

 Return the node with the largest depth such that it contains all the deepest nodes in it's subtree.

 Input: [3,5,1,6,2,0,8,null,null,7,4]
 Output: [2,7,4]

 */
public class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode root) {
        if (null == root) {
            return new Result(0, null);
        }

        Result lResult = dfs(root.left), rResult = dfs(root.right);

        if (lResult.depth > rResult.depth) {
            return new Result(lResult.depth + 1, lResult.node);
        }

        if (rResult.depth > lResult.depth) {
            return new Result(rResult.depth + 1, rResult.node);
        }

        return new Result(lResult.depth + 1, root);
    }
}

class Result {
    int depth;
    TreeNode node;

    public Result(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}
