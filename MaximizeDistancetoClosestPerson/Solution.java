package MaximizeDistancetoClosestPerson;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

 There is at least one empty seat, and at least one person sitting.

 Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

 Return that maximum distance to closest person.

 Example 1:

 Input: [1,0,0,0,1,0,1]
 Output: 2
 Explanation:
 If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 If Alex sits in any other open seat, the closest person has distance 1.
 Thus, the maximum distance to the closest person is 2.
 Example 2:

 Input: [1,0,0,0]
 Output: 3
 Explanation:
 If Alex sits in the last seat, the closest person is 3 seats away.
 This is the maximum distance possible, so the answer is 3.
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int j = -1, maxDist = 0;
        for (int i = 0; i < seats.length; ++i) {
            if (seats[i] == 1) {
                if (j != -1) {
                    maxDist = Math.max(maxDist, (i - j) / 2); //Get middle point between two taken seats
                }
                else {
                    maxDist = Math.max(maxDist, i - j - 1); //Get distance between index 0 to first taken seat, since j = -1, we need to make distance here -1 also.
                }
                j = i;
            }
            else if (i == seats.length - 1) {
                maxDist = Math.max(maxDist, i - j); //Get distance between last taken seat to index n - 1
            }
        }
        return maxDist;
    }
}
