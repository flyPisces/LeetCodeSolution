package RobotRoomCleaner;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a robot cleaner in a room modeled as a grid.
 *
 * Each cell in the grid can be empty or blocked.
 *
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 *
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 *
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 *
 * interface Robot {
 *   // returns true if next cell is open and robot moves into the cell.
 *   // returns false if next cell is obstacle and robot stays on the current cell.
 *   boolean move();
 *
 *   // Robot will stay on the same cell after calling turnLeft/turnRight.
 *   // Each turn will be 90 degrees.
 *   void turnLeft();
 *   void turnRight();
 *
 *   // Clean the current cell.
 *   void clean();
 * }
 * Example:
 *
 * Input:
 * room = [
 *   [1,1,1,1,1,0,1,1],
 *   [1,1,1,1,1,0,1,1],
 *   [1,0,1,1,1,1,1,1],
 *   [0,0,0,1,0,0,0,0],
 *   [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 *
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 */
public class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        int curr_dirr = 0;
        dfs(0, 0, 0, visited, robot);
    }

    private void dfs(int i, int j, int curr_dirr, Set<String> visited, Robot robot) {
        String temp = i + "->" + j;
        if (visited.contains(temp)) {
            return;
        }

        visited.add(temp);
        robot.clean();

        for (int k = 0;k < 4;++ k) {
            int newX = i, newY = j;
            if (robot.move()) {
                switch (curr_dirr) {
                    case 0:
                        newX = newX - 1;
                        break;
                    case 90:
                        newY = newY + 1;
                        break;
                    case 180:
                        newX = newX + 1;
                        break;
                    case 270:
                        newY = newY - 1;
                        break;
                }

                dfs(newX, newY, curr_dirr, visited, robot);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }

            robot.turnRight();
            curr_dirr = (curr_dirr + 90) % 360;
        }
    }
}
