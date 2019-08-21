package HeightChecker;

import java.util.Arrays;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.

 Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)



 Example 1:

 Input: [1,1,4,2,1,3]
 Output: 3
 Explanation:
 Students with heights 4, 3 and the last 1 are not standing in the right positions.
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int[] clone = heights.clone();

        Arrays.sort(clone);

        int result = 0;
        for (int i = 0;i < clone.length;++ i) {
            if (heights[i] != clone[i]) {
                result++;
            }
        }

        return result;
    }
}
