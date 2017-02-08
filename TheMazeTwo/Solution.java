package TheMazeTwo;

import java.util.*;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

 Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

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

 Output: 12
 Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

 Example 2

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (3, 2)

 Output: -1
 Explanation: There is no way for the ball to stop at the destination.

 Note:
 There is only one ball and one destination in the maze.
 Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 * Created by aoshen on 2/3/17.
 */
public class Solution {
    class Point {
        int x, y, l;
        public Point(int _x, int _y, int _l) {
            x = _x;
            y = _y;
            l = _l;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) return 0;
        int m = maze.length, n = maze[0].length;
        int[][] flags = new int[m][n];
        for (int i = 0;i < m;++ i) {
            for (int j = 0;j < n;++ j) {
                flags[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        PriorityQueue<Point> list=new PriorityQueue<>((o1,o2)->o1.l-o2.l);
        list.offer(new Point(start[0], start[1], 0));

        while (!list.isEmpty()) {
            Point p = list.poll();
            if (flags[p.x][p.y] <= p.l) continue;
            flags[p.x][p.y] = p.l;

            for (int i = 0;i < 4;++ i) {
                int xx = p.x, yy = p.y, l = p.l;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += dir[i][0];
                    yy += dir[i][1];
                    l ++;
                }

                xx -= dir[i][0];
                yy -= dir[i][1];
                l --;
                list.offer(new Point(xx, yy, l));
            }
        }

        return flags[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:flags[destination[0]][destination[1]];
    }
}
