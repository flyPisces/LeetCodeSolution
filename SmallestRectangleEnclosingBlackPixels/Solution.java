package SmallestRectangleEnclosingBlackPixels;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 *
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels,
 * return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

 For example, given the following image:

 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,
 Return 6.

 * Created by aoshen on 7/30/16.
 */
public class Solution {
    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = 0;
    private int maxY = 0;

    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;

        dfs(image, x, y);

        return (maxY - minY + 1) * (maxX - minX + 1);
    }

    private void dfs(char[][] image, int r, int c) {
        int rows = image.length;
        int cols = image[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || image[r][c] == '0') return;

        image[r][c] = '0';

        minX = Math.min(minX, r);
        minY = Math.min(minY, c);
        maxX = Math.max(maxX, r);
        maxY = Math.max(maxY, c);

        dfs(image, r + 1, c);
        dfs(image, r - 1, c);
        dfs(image, r, c - 1);
        dfs(image, r, c + 1);
    }
}
