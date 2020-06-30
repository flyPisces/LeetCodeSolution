package GetEqualSubstringsWithinBudget;

/**
 * You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
 *
 * You are also given an integer maxCost.
 *
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
 *
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 */
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0;

        int sum = 0;
        for (int i = 0, j = 0;i < s.length();++ i) {
            sum += Math.abs(s.charAt(i) - t.charAt(i));

            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(j) - t.charAt(j));
                j ++;
            }

            result = Math.max(result, i - j + 1);
        }

        return result;
    }
}
