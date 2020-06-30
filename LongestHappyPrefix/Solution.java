package LongestHappyPrefix;

/**
 * A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).
 *
 * Given a string s. Return the longest happy prefix of s .
 *
 * Return an empty string if no such prefix exists.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "level"
 * Output: "l"
 * Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
 * Example 2:
 *
 * Input: s = "ababab"
 * Output: "abab"
 * Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 * Example 3:
 *
 * Input: s = "leetcodeleet"
 * Output: "leet"
 * Example 4:
 *
 * Input: s = "a"
 * Output: ""
 */
public class Solution {
    public String longestPrefix(String s) {
        long l = 0, r = 0, p = 1, mod = (long) 1e9 + 7;
        int n = s.length(), k = 0;

        for (int i = 0;i < n - 1;++ i) {
            l = (l * 128 + s.charAt(i)) % mod;
            r = (r + p * s.charAt(n - 1 - i)) % mod;

            if (l == r) k = i + 1;
            p = (p * 128) % mod;
        }

        return s.substring(0, k);
    }
}
