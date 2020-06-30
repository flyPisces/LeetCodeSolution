package CountSubstringswithOnlyOneDistinctLetter;

/**
 * Given a string S, return the number of substrings that have only one distinct letter.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "aaaba"
 * Output: 8
 * Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
 * "aaa" occurs 1 time.
 * "aa" occurs 2 times.
 * "a" occurs 4 times.
 * "b" occurs 1 time.
 * So the answer is 1 + 2 + 4 + 1 = 8.
 * Example 2:
 *
 * Input: S = "aaaaaaaaaa"
 * Output: 55
 */

public class Solution {
    public int countLetters(String S) {
        if (S.length() == 0) return 0;

        char prev = S.charAt(0);
        int sum = 0, repeat = 1;

        for (int i = 1;i <= S.length();++ i) {
            if (i == S.length()) {
                sum += repeat * (repeat + 1) / 2;
            } else if (prev != S.charAt(i)) {
                sum += repeat * (repeat + 1) / 2;

                repeat = 1;
                prev = S.charAt(i);
            } else {
                repeat ++;
            }
        }

        return sum;
    }
}
