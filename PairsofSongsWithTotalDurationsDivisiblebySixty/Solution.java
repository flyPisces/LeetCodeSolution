package PairsofSongsWithTotalDurationsDivisiblebySixty;

import java.util.*;

/**
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> countMapping = new HashMap<>();

        int result = 0;

        for (int num : time) {
            int other = (60 - num % 60) % 60;
            result += countMapping.getOrDefault(other, 0);
            countMapping.put(num % 60, countMapping.getOrDefault(num % 60, 0) + 1);
        }

        return result;
    }
}
