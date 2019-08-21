package SwapForLongestRepeatedCharacterSubstring;

/**
 * Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.



 Example 1:

 Input: text = "ababa"
 Output: 3
 Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
 Example 2:

 Input: text = "aaabaaa"
 Output: 6
 Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa", which its length is 6.
 Example 3:

 Input: text = "aaabbaaa"
 Output: 4
 Example 4:

 Input: text = "aaaaa"
 Output: 5
 Explanation: No need to swap, longest repeated character substring is "aaaaa", length is 5.
 Example 5:

 Input: text = "abcdef"
 Output: 1
 */
public class Solution {
    public int maxRepOpt1(String text) {
        int max = 0;

        int[] dp = new int[26];
        for (int i = 0;i < text.length();++ i) {
            dp[text.charAt(i) - 'a'] ++;
        }

        for (int i = 0;i < text.length();++ i) {
            int j = i, diff = 0, count = 0;
            char curr = text.charAt(i);

            while (j < text.length() && (diff == 0 || curr == text.charAt(j)) && count < dp[curr - 'a']) {
                if (curr != text.charAt(j)) ++ diff;
                count ++;
                ++ j;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
