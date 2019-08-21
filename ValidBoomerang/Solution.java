package ValidBoomerang;

/**
 * A boomerang is a set of 3 points that are all distinct and not in a straight line.

 Given a list of three points in the plane, return whether these points are a boomerang.



 Example 1:

 Input: [[1,1],[2,3],[3,2]]
 Output: true
 Example 2:

 Input: [[1,1],[2,2],[3,3]]
 Output: false
 */
public class Solution {
    public boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }
}
