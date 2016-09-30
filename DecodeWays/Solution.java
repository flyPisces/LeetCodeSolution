package DecodeWays;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
 ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.
 *
 *  Created by aoshen on 5/6/16.
 */
public class
Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        if (isValid(s.substring(0, 1))) {
            dp[1] = 1;
        }

        for (int i = 2;i <= s.length();++ i) {
            if (isValid(s.substring(i - 1, i))) {
                dp[i] += dp[i - 1];
            }

            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    public boolean isValid(String subString) {
        if (subString.charAt(0) == '0') {
            return false;
        }

        Integer num = Integer.parseInt(subString);

        if (num > 0 && num <= 26) {
            return true;
        }

        return false;
    }
}
