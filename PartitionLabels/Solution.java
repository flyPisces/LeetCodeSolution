package PartitionLabels;

import java.util.*;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 Example 1:
 Input: S = "ababcbacadefegdehijhklij"
 Output: [9,7,8]
 Explanation:
 The partition is "ababcbaca", "defegde", "hijhklij".
 This is a partition so that each letter appears in at most one part.
 A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> results = new ArrayList<>();

        int[] dp = new int[26];
        for (int i = 0;i < S.length();++ i) {
            dp[S.charAt(i) - 'a'] = i;
        }

        int start = 0, max = 0;
        for (int i = 0;i < S.length();++ i) {
            max = Math.max(max, dp[S.charAt(i) - 'a']);

            if (max == i) {
                results.add(i - start + 1);
                start = i + 1;
            }
        }

        return results;
    }
}
