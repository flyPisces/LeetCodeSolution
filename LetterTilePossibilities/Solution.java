package LetterTilePossibilities;

/**
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.



 Example 1:

 Input: "AAB"
 Output: 8
 Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 Example 2:

 Input: "AAABBC"
 Output: 188
 */
public class Solution {
    public int numTilePossibilities(String tiles) {
        int[] dp = new int[26];

        for (char c : tiles.toCharArray()) {
            dp[c - 'A'] ++;
        }

        return dfs(dp);
    }

    private int dfs(int[] dp) {
        int sum = 0;

        for (int i = 0;i < 26;++ i) {
            if (dp[i] == 0) continue;

            dp[i] --;
            sum ++;

            sum += dfs(dp);
            dp[i] ++;
        }

        return sum;
    }
}
