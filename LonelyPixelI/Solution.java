package LonelyPixelI;

/**
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.

 The picture is represented by a 2D char array consisting of 'B' and 'W',
 which means black and white pixels respectively.

 A black lonely pixel is character 'B' that located at a specific position
 where the same row and same column don't have any other black pixels.

 Example:
 Input:
 [['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

 Output: 3
 Explanation: All the three 'B's are black lonely pixels.

 * Created by aoshen on 3/6/17.
 */
public class Solution {
    public int findLonelyPixel(char[][] picture) {
        int rows = picture.length, cols = picture[0].length;

        int[] rNums = new int[rows];
        int[] cNums = new int[cols];

        for (int i = 0;i < rows;++ i) {
            for (int j = 0;j < cols;++ j) {
                if (picture[i][j] == 'B') {
                    rNums[i] ++;
                    cNums[j] ++;
                }
            }
        }

        int count = 0;
        for (int i = 0;i < rows;++ i) {
            for (int j = 0; j < cols; ++j) {
                if (picture[i][j] == 'B' && rNums[i] == 1 && cNums[j] == 1) {
                    ++ count;
                }
            }
        }

        return count;
    }
}
