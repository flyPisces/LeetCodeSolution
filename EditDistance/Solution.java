package EditDistance;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

    You have the following 3 operations permitted on a word:

    a) Insert a character
    b) Delete a character
    c) Replace a character
 *
 * Created by aoshen on 4/15/16.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] mins = new int[len1 + 1][len2 + 1];

        for (int i = 0;i <=len2;++ i) {
            mins[0][i] = i;
        }

        for (int i = 0;i <= len1;++ i) {
            mins[i][0] = i;
        }

        for (int i = 1;i <= len1;++ i) {
            char m = word1.charAt(i - 1);
            for (int j = 1;j <= len2;++ j) {
                char n = word2.charAt(j - 1);

                if (m == n) {
                    mins[i][j] = mins[i - 1][j - 1];
                } else {
                    mins[i][j] = Math.min(mins[i - 1][j - 1] + 1, Math.min(mins[i - 1][j], mins[i][j - 1]) + 1);
                }
            }
        }

        return mins[len1][len2];
    }
}
