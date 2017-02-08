package TheMazeThree;

import java.util.*;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

 Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

 The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

 Example 1

 Input 1: a maze represented by a 2D array

 0 0 0 0 0
 1 1 0 0 1
 0 0 0 0 0
 0 1 0 0 1
 0 1 0 0 0

 Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 Input 3: hole coordinate (rowHole, colHole) = (0, 1)

 Output: "lul"
 Explanation: There are two shortest ways for the ball to drop into the hole.
 The first way is left -> up -> left, represented by "lul".
 The second way is up -> left, represented by 'ul'.
 Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

 Example 2

 Input 1: a maze represented by a 2D array

 0 0 0 0 0
 1 1 0 0 1
 0 0 0 0 0
 0 1 0 0 1
 0 1 0 0 0

 Input 2: ball coordinate (rowBall, colBall) = (4, 3)
 Input 3: hole coordinate (rowHole, colHole) = (3, 0)
 Output: "impossible"
 Explanation: The ball cannot reach the hole.

 Note:
 There is only one ball and one hole in the maze.
 Both the ball and hole exist on an empty space, and they will not be at the same position initially.
 The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.

 * Created by aoshen on 2/5/17.
 */
public class Solution {
    int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    char[] dirc = {'d', 'l', 'r', 'u'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        String misS = null;
        int min = Integer.MAX_VALUE;

        int[][] map = new int[m][n];
        for (int i = 0;i < m;++ i) Arrays.fill(map[i], Integer.MAX_VALUE);

        Node start = new Node(ball[0], ball[1], 0, "");
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(start);

        boolean[][] visited = new boolean[m][n];
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            visited[curr.x][curr.y] = true;

            for (int d = 0;d < 4;++ d) {
                int x = curr.x, y = curr.y;

                while (x + dirs[d][0] < m && x + dirs[d][0] >= 0 &&
                        y + dirs[d][1] < n && y + dirs[d][1] >= 0 &&
                        maze[x + dirs[d][0]][y + dirs[d][1]] != 1) {
                    x += dirs[d][0];
                    y += dirs[d][1];

                    if (visited[x][y] || (x == hole[0] && y == hole[1])) break;
                }

                int step = curr.step + Math.abs(x - curr.x) + Math.abs(y - curr.y);
                if (visited[x][y] || step > map[x][y]) continue;
                map[x][y] = step;
                Node next = new Node(x, y, step, curr.route + dirc[d]);

                if (x == hole[0] && y == hole[1]) {
                    if (step == min && (misS == null || next.route.compareTo(misS) < 0)) {
                        misS = next.route;
                    } else if (step < min) {
                        min = step;
                        misS = next.route;
                    }

                    break;
                }

                pq.add(next);
            }
        }

        return misS == null ? "impossible" : misS;
    }
}
