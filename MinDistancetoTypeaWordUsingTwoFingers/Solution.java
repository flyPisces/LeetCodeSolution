package MinDistancetoTypeaWordUsingTwoFingers;

/**
 * You have a keyboard layout as shown above in the XY plane, where each English uppercase letter is located at some coordinate, for example, the letter A is located at coordinate (0,0), the letter B is located at coordinate (0,1), the letter P is located at coordinate (2,3) and the letter Z is located at coordinate (4,1).
 *
 * Given the string word, return the minimum total distance to type such string using only two fingers. The distance between coordinates (x1,y1) and (x2,y2) is |x1 - x2| + |y1 - y2|.
 *
 * Note that the initial positions of your two fingers are considered free so don't count towards your total distance, also your two fingers do not have to start at the first letter or the first two letters.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "CAKE"
 * Output: 3
 * Explanation:
 * Using two fingers, one optimal way to type "CAKE" is:
 * Finger 1 on letter 'C' -> cost = 0
 * Finger 1 on letter 'A' -> cost = Distance from letter 'C' to letter 'A' = 2
 * Finger 2 on letter 'K' -> cost = 0
 * Finger 2 on letter 'E' -> cost = Distance from letter 'K' to letter 'E' = 1
 * Total distance = 3
 * Example 2:
 *
 * Input: word = "HAPPY"
 * Output: 6
 * Explanation:
 * Using two fingers, one optimal way to type "HAPPY" is:
 * Finger 1 on letter 'H' -> cost = 0
 * Finger 1 on letter 'A' -> cost = Distance from letter 'H' to letter 'A' = 2
 * Finger 2 on letter 'P' -> cost = 0
 * Finger 2 on letter 'P' -> cost = Distance from letter 'P' to letter 'P' = 0
 * Finger 1 on letter 'Y' -> cost = Distance from letter 'A' to letter 'Y' = 4
 * Total distance = 6
 * Example 3:
 *
 * Input: word = "NEW"
 * Output: 3
 * Example 4:
 *
 * Input: word = "YEAR"
 * Output: 7
 */
public class Solution {
    private int dist(int source, int dest) {
        if (source == 26) return 0;
        int x1 = source / 6;
        int y1 = source % 6;
        int x2 = dest / 6;
        int y2 = dest % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int[][][] dp = new int[word.length() + 1][27][27];

        for (int i = word.length() - 1;i >= 0;-- i) {
            for (int j = 0;j < 27;++ j) {
                for (int k = 0;k < 27;++ k) {
                    int dist1 = dist(j, word.charAt(i) - 'A');
                    int dist2 = dist(k, word.charAt(i) - 'A');

                    dp[i][j][k] = Math.min(dp[i + 1][word.charAt(i) - 'A'][k] + dist1, dp[i + 1][j][word.charAt(i) - 'A'] + dist2);
                }
            }
        }

        return dp[0][26][26];
    }

    // optimization: https://www.youtube.com/watch?v=GRRDl3HxQAI
}
