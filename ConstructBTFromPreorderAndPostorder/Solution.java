package ConstructBTFromPreorderAndPostorder;

/**
 * Return any binary tree that matches the given preorder and postorder traversals.

 Values in the traversals pre and post are distinct positive integers.



 Example 1:

 Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 Output: [1,2,3,4,5,6,7]
 */
public class Solution {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) return null;

        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        TreeNode head = new TreeNode(pre[preStart]);

        int leftVal = pre[preStart + 1], leftSize = 0;

        for (int i = postStart;i <= postEnd;++ i) {
            if (post[i] != leftVal) {
                ++ leftSize;
            } else {
                break;
            }
        }
        ++ leftSize;

        head.left = dfs(pre, preStart + 1, preStart + leftSize, post, postStart, postStart + leftSize - 1);
        head.right = dfs(pre, preStart + leftSize + 1, preEnd, post, postStart + leftSize, postEnd - 1);

        return head;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.constructFromPrePost(new int[] {1,2,4,5,3,6,7}, new int[] {4,5,2,6,7,3,1});
    }
}
