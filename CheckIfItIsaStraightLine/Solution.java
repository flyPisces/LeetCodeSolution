package CheckIfItIsaStraightLine;

/**
 *
 You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 Output: false
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], y1 = coordinates[0][1], x2 = coordinates[1][0], y2 = coordinates[1][1];

        for (int[] coordinate : coordinates) {
            if ((coordinate[0] - x1) * (coordinate[1] - y2) != (coordinate[0] - x2) * (coordinate[1] - y1)) return false;
        }

        return true;
    }
}
