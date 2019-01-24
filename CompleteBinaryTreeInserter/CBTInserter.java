package CompleteBinaryTreeInserter;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

 Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

 CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
 CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
 CBTInserter.get_root() will return the head node of the tree.


 Example 1:

 Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 Output: [null,1,[1,2]]
 Example 2:

 Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 */
public class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue.offer(root);

        while (queue.peek().left != null && queue.peek().right != null) {
            queue.offer(queue.peek().left);
            queue.offer(queue.poll().right);
        }
    }

    public int insert(int v) {
        TreeNode top = queue.peek();

        if (top.left == null) {
            top.left = new TreeNode(v);
        } else {
            top.right = new TreeNode(v);
            queue.offer(top.left);
            queue.offer(top.right);
            queue.poll();
        }

        return top.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
