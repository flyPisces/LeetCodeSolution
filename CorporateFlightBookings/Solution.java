package CorporateFlightBookings;

/**
 * There are n flights, and they are labeled from 1 to n.

 We have a list of flight bookings.  The i-th booking bookings[i] = [i, j, k] means that we booked k seats from flights labeled i to j inclusive.

 Return an array answer of length n, representing the number of seats booked on each flight in order of their label.



 Example 1:

 Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 Output: [10,55,45,25,25]
 */
public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] results = new int[n];

        for (int[] booking : bookings) {
            results[booking[0] - 1] += booking[2];
            if (booking[1] < n)
                results[booking[1]] -= booking[2];
        }

        int sum = 0;

        for (int i = 0;i < n;++ i) {
            sum += results[i];
            results[i] = sum;
        }

        return results;
    }
}
