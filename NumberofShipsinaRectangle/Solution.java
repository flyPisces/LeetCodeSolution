package NumberofShipsinaRectangle;

/**
 * On the sea represented by a cartesian plane, each ship is located at an integer point, and each integer point may contain at most 1 ship.
 *
 * You have a function Sea.hasShips(topRight, bottomLeft) which takes two points as arguments and returns true if and only if there is at least one ship in the rectangle represented by the two points, including on the boundary.
 *
 * Given two points, which are the top right and bottom left corners of a rectangle, return the number of ships present in that rectangle.  It is guaranteed that there are at most 10 ships in that rectangle.
 *
 * Submissions making more than 400 calls to hasShips will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * Input:
 * ships = [[1,1],[2,2],[3,3],[5,5]], topRight = [4,4], bottomLeft = [0,0]
 * Output: 3
 * Explanation: From [0,0] to [4,4] we can count 3 ships within the range.
 */
public class Solution {

    // be aware of +1
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;

        int midX = (bottomLeft[0] + topRight[0]) / 2, midY = (bottomLeft[1] + topRight[1]) / 2;

        return countShips(sea, new int[] {midX, topRight[1]}, new int[] {bottomLeft[0], midY + 1}) +
                countShips(sea, new int[] {midX, midY}, bottomLeft) +
                countShips(sea, topRight, new int[] {midX + 1, midY + 1}) +
                countShips(sea, new int[] {topRight[0], midY}, new int[] {midX + 1, bottomLeft[1]});
    }
}
