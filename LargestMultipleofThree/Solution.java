package LargestMultipleofThree;

/**
 * Given an integer array of digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order.
 *
 * Since the answer may not fit in an integer data type, return the answer as a string.
 *
 * If there is no answer return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [8,1,9]
 * Output: "981"
 * Example 2:
 *
 * Input: digits = [8,6,7,1,0]
 * Output: "8760"
 * Example 3:
 *
 * Input: digits = [1]
 * Output: ""
 * Example 4:
 *
 * Input: digits = [0,0,0,0,0,0]
 * Output: "0"
 *
 */
public class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] dp = new int[10];
        for (int digit: digits) {
            dp[digit] ++;
        }

        int remain1Cnt = dp[1] + dp[4] + dp[7];
        int remain2Cnt = dp[2] + dp[5] + dp[8];
        int remain = (remain1Cnt + 2 * remain2Cnt) % 3;

        if (remain == 1) {
            if (remain1Cnt >= 1) --remain1Cnt;
            else remain2Cnt -= 2;
        } else if (remain == 2) {
            if (remain2Cnt >= 1) --remain2Cnt;
            else  remain1Cnt -= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int d = 9;d >= 0;-- d) {
            if (d % 3 == 0) {
                while (dp[d] -- > 0) sb.append(d);
            } else if (d % 3 == 1) {
                while (dp[d] -- > 0 && remain1Cnt -- > 0) sb.append(d);
            } else {
                while (dp[d] -- > 0 && remain2Cnt -- > 0) sb.append(d);
            }
        }

        if (sb.length() > 0 && sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
