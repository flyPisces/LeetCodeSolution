package LonelyPixelTwo;

import java.util.*;

/**
 * Given a picture consisting of black and white pixels, and a positive integer N,
 * find the number of black pixels located at some specific row R and column C that align with all the following rules:

 Row R and column C both contain exactly N black pixels.
 For all rows that have a black pixel at column C, they should be exactly the same as row R
 The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

 Example:
 Input:
 [['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'W', 'B', 'W', 'B', 'W']]

 N = 3
 Output: 6
 Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
 0    1    2    3    4    5         column index
 0    [['W', 'B', 'W', 'B', 'B', 'W'],
 1     ['W', 'B', 'W', 'B', 'B', 'W'],
 2     ['W', 'B', 'W', 'B', 'B', 'W'],
 3     ['W', 'W', 'B', 'W', 'B', 'W']]
 row index

 Take 'B' at row R = 0 and column C = 1 as an example:
 Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
 Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.

 * Created by aoshen on 3/7/17.
 */
public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture.length == 0) return 0;
        if (picture[0].length == 0) return 0;

        Map<String, Integer> mapping = new HashMap<>();
        int[] cols = new int[picture[0].length];

        for (int i = 0;i < picture.length;++ i) {
            String res = scanRow(picture, i, cols, N);
            if (!res.isEmpty()) {
                mapping.put(res, mapping.getOrDefault(res, 0) + 1);
            }
        }

        int result = 0;
        for (String key : mapping.keySet()) {
            if (mapping.get(key) == N) {
                for (int j = 0;j < picture[0].length;++ j) {
                    if (cols[j] == N && key.charAt(j) == 'B') {
                        result += N;
                    }
                }
            }
        }

        return result;
    }

    private String scanRow(char[][] picture, int row, int[] cols, int target) {
        int size = cols.length;

        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int j = 0;j < size;++ j) {
            if (picture[row][j] == 'B') {
                cols[j] ++;
                num ++;
            }
            sb.append(picture[row][j]);
        }

        if (num == target) return sb.toString();
        return "";
    }
}
