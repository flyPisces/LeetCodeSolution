package FindaCorrespondingNodeofaBTinaClone;

/**
 *
 Given two binary trees original and cloned and given a reference to a node target in the original tree.

 The cloned tree is a copy of the original tree.

 Return a reference to the same node in the cloned tree.

 Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

 Follow up: Solve the problem if repeated values on the tree are allowed.
 */
public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (null == original) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode lNode = getTargetCopy(original.left, cloned.left, target);

        if (lNode != null) return lNode;

        return getTargetCopy(original.right, cloned.right, target);
    }
}
