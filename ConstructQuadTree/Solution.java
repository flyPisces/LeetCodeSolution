package ConstructQuadTree;

/**
 * Given a n * n matrix grid of 0's and 1's only. We want to represent the grid with a Quad-Tree.
 *
 * Return the root of the Quad-Tree representing the grid.
 *
 * Notice that you can assign the value of a node to True or False when isLeaf is False, and both are accepted in the answer.
 *
 * A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:
 *
 * val: True if the node represents a grid of 1's or False if the node represents a grid of 0's.
 * isLeaf: True if the node is leaf node on the tree or False if the node has the four children.
 * class Node {
 *     public boolean val;
 *     public boolean isLeaf;
 *     public Node topLeft;
 *     public Node topRight;
 *     public Node bottomLeft;
 *     public Node bottomRight;
 * }
 * We can construct a Quad-Tree from a two-dimensional area using the following steps:
 *
 * If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
 * If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
 * Recurse for each of the children with the proper sub-grid.
 */
public class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    private Node dfs(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] != 0, true, null, null, null, null);
        }

        Node result = new Node();

        Node topLeft = dfs(grid, x, y, len / 2);
        Node topRight = dfs(grid, x, y + len / 2, len / 2);
        Node bottomLeft = dfs(grid, x + len /2, y, len /2);
        Node bottomRight = dfs(grid, x + len / 2, y + len / 2, len / 2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            result.isLeaf = true;
            result.val = topLeft.val;
        } else {
            result.topLeft = topLeft;
            result.topRight = topRight;
            result.bottomLeft = bottomLeft;
            result.bottomRight = bottomRight;
        }

        return result;
    }
}
