package AllPossibleFullBT;

import java.util.*;

/**
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.

 Return a list of all possible full binary trees with N nodes.
 Each element of the answer is the root node of one possible tree.

 Each node of each tree in the answer must have node.val = 0.

 You may return the final list of trees in any order.
 */
public class Solution {
    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {

        if (!memo.containsKey(N)) {
            List<TreeNode> results = new ArrayList<>();

            if (1 == N) {
                results.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int i = 0;i < N;++ i) {
                    int j = N - 1 - i;

                    for (TreeNode left : allPossibleFBT(i)) {
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode head = new TreeNode(0);
                            head.left = left;
                            head.right = right;

                            results.add(head);
                        }
                    }
                }
            }

            memo.put(N, results);
        }

        return memo.get(N);
    }
}
