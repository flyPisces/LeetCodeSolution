package BinaryWatch;

import java.util.*;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 Note:
 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * Created by aoshen on 9/23/16.
 */
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> results = new ArrayList<>();
        int[] dp = new int[10];
        helper(num, dp, 0, 0, results );

        return results;
    }

    private void helper(int num, int[] dp, int i, int k, List<String> results) {
        if (k == num) {
            String res = getTime(dp);
            if (res != null) {
                results.add(res);
            }
            return;
        }

        if (i == dp.length) {
            return;
        }

        dp[i] = 0;
        helper(num, dp, i + 1, k, results);

        dp[i] = 1;
        helper(num, dp, i + 1, k + 1, results);

        dp[i] = 0;
    }

    private String getTime(int[] dp) {
        int hours = 0;
        for (int i = 0;i < 4;++ i) {
            if (dp[i] == 1) {
                hours += Math.pow(2, i);
            }
        }

        int minutes = 0;
        for (int i = 4;i < 10;++ i) {
            if (dp[i] == 1) {
                minutes += Math.pow(2, i - 4);
            }
        }

        if (hours >= 12 || minutes >= 60) {
            return null;
        }

        String min = String.valueOf(minutes);
        if (minutes < 10) {
            min = "0" + min;
        }

        return (String.valueOf(hours) + ":" + min);
    }
}
