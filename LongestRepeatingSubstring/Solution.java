package LongestRepeatingSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.
 *
 *
 *
 * Example 1:
 *
 * Input: "abcd"
 * Output: 0
 * Explanation: There is no repeating substring.
 * Example 2:
 *
 * Input: "abbaba"
 * Output: 2
 * Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
 * Example 3:
 *
 * Input: "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 * Example 4:
 *
 * Input: "aaaaa"
 * Output: 4
 * Explanation: The longest repeating substring is "aaaa", which occurs twice.
 */
public class Solution {
    public int longestRepeatingSubstring(String S) {
        int left = 0, right = S.length() - 1;
        char[] arr = S.toCharArray();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (search(arr, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1;
    }

    boolean search(char[] arr, int k) {
        long curr = 0, MOD = 10000000007L, pow = 1;
        Set<Long> visited = new HashSet<>();

        for (int i = 0;i < arr.length;++ i) {
            curr = (26 * curr + arr[i] - 'a') % MOD;

            if (i >= k) {
                curr = (curr - pow * (arr[i - k] - 'a') % MOD + MOD) % MOD;
            } else {
                pow = pow * 26 % MOD;
            }

            if (i >= k - 1 && !visited.add(curr)) return true;
        }

        return false;
    }
}
