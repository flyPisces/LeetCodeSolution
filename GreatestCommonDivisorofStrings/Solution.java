package GreatestCommonDivisorofStrings;

/**
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 */
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int len1, int len2) {
        if (len2 == 0) return len1;

        return gcd(len2, len1 % len2);
    }
}
