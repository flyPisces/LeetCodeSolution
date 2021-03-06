package Heaters;

import java.util.Arrays;

/**
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

 Now, you are given positions of houses and heaters on a horizontal line,
 find out minimum radius of heaters so that all houses could be covered by those heaters.

 So, your input will be the positions of houses and heaters seperately,
 and your expected output will be the minimum radius standard of heaters.

 Note:
 Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 As long as a house is in the heaters' warm radius range, it can be warmed.
 All the heaters follow your radius standard and the warm radius will the same.
 Example 1:
 Input: [1,2,3],[2]
 Output: 1
 Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard,
 then all the houses can be warmed.
 Example 2:
 Input: [1,2,3,4],[1,4]
 Output: 1
 Explanation: The two heater was placed in the position 1 and 4.
 We need to use radius 1 standard, then all the houses can be warmed.

 * Created by aoshen on 12/14/16.
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(heaters);

        for (int house : houses) {
            int idx = Arrays.binarySearch(heaters, house);

            if (idx < 0) idx = -(idx + 1);

            int dist1 = idx - 1 >= 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
            int dist2 = idx < heaters.length ? heaters[idx] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }

        return result;
    }
}
