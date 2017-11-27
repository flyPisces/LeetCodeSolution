package StrangePrinter;

/**
 * There is a strange printer with the following two special requirements:

 The printer can only print a sequence of the same character each time.
 At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
 Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

 Example 1:
 Input: "aaabbb"
 Output: 2
 Explanation: Print "aaa" first and then print "bbb".
 Example 2:
 Input: "aba"
 Output: 2
 Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the ex

 * Created by aoshen on 8/25/17.
 */
public class Solution {
    public int strangePrinter(String s) {
        int len = s.length();
        if (len == 0) return 0;

        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                dp[j][j + i] = i + 1;
                for (int k = j + 1; k <= j + i; k++) {
                    int temp = dp[j][k - 1] + dp[k][j + i];
                    if (s.charAt(k - 1) == s.charAt(j + i)) temp--;
                    dp[j][j + i] = Math.min(dp[j][j + i], temp);
                }
            }
        }
        return dp[0][len - 1];
    }
}
