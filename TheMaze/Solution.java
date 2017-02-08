package TheMaze;

import java.util.LinkedList;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

 Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

 The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

 Example 1

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (4, 4)

 Output: true
 Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

 Example 2

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (3, 2)

 Output: false
 Explanation: There is no way for the ball to stop at the destination.

 Note:
 There is only one ball and one destination in the maze.
 Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 * Created by aoshen on 2/1/17.
 */
public class Solution {
    class Point {
        int x,y;
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] flags = new boolean[m][n];
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dir = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        LinkedList<Point> bfs = new LinkedList<>();
        flags[start[0]][start[1]] = true;
        bfs.offer(new Point(start[0], start[1]));

        while (!bfs.isEmpty()) {
            Point top = bfs.poll();
            int x = top.x, y = top.y;
            for (int i = 0;i < 4;++ i) {
                int xx = x, yy = y;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                }
                xx -= dir[i][0];
                yy -= dir[i][1];
                if (flags[xx][yy]) continue;
                flags[xx][yy] = true;
                if (xx == destination[0] && yy == destination[1]) return true;
                bfs.offer(new Point(xx, yy));
            }
        }

        return false;
    }
}
