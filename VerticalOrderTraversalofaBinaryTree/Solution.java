package VerticalOrderTraversalofaBinaryTree;

import java.util.*;

/**
 *
 Given a binary tree, return the vertical order traversal of its nodes values.

 For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

 Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

 If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

 Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 Input: [3,9,20,null,null,15,7]
 Output: [[9],[3,15],[20],[7]]
 Explanation:
 Without loss of generality, we can assume the root node is at position (0, 0):
 Then, the node with value 9 occurs at position (-1, -1);
 The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 The node with value 20 occurs at position (1, -1);
 The node with value 7 occurs at position (2, -2).

 Input: [1,2,3,4,5,6,7]
 Output: [[4],[2],[1,5,6],[3],[7]]
 Explanation:
 The node with value 5 and the node with value 6 have the same position according to the given scheme.
 However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 */
public class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        PriorityQueue<Point> pq = new PriorityQueue<>(100, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x < o2.x) return -1;
                if (o1.x > o2.x) return 1;
                if (o1.y > o2.y) return -1;
                if (o1.y < o2.y) return 1;

                return o1.val - o2.val;
            }
        });

        dfs(root, 0,0, pq);

        Point prev = null;
        List<Integer> l = new ArrayList<>();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (prev == null || p.x != prev.x) {
                if (prev != null) results.add(l);
                l = new ArrayList<>();
            }
            l.add(p.val);
            prev = p;
        }

        if (results.size() > 0) results.add(l);

        return results;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Point> pq) {
        if (root == null) return;
        pq.offer(new Point(x, y, root.val));
        dfs(root.left, x - 1, y - 1, pq);
        dfs(root.right, x + 1, y - 1, pq);

    }
}

class Point {
    int x, y, val;

    Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
