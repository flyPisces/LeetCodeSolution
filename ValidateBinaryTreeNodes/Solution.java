package ValidateBinaryTreeNodes;

/**
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 *
 *
 */
public class Solution {

    int n = 0;

    private void dfs(int root, int[] leftChild, int[] rightChild) {
        if (root == -1) return;
        this.n --;

        dfs(leftChild[root], leftChild, rightChild);
        dfs(rightChild[root], leftChild, rightChild);
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        this.n = n;

        int[] inDegree = new int[n];
        for (int i = 0;i < n;++ i) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]] ++;
                if (inDegree[leftChild[i]] > 1) return false;
            }

            if (rightChild[i] != -1) {
                inDegree[rightChild[i]] ++;
                if (inDegree[rightChild[i]] > 1) return false;
            }
        }

        int root = -1;
        for (int i = 0;i < n;++ i) {
            if (inDegree[i] == 0) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }

        dfs(root, leftChild, rightChild);

        return this.n == 0;
    }
}
