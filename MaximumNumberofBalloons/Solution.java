package MaximumNumberofBalloons;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 */
public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] dp = new int[26];

        for (char c : text.toCharArray()) {
            dp[c - 'a'] ++;
        }

        int result = dp['b' - 'a'] / 1;
        result = Math.min(result, dp['a' - 'a'] / 1);
        result = Math.min(result, dp['l' - 'a'] / 2);
        result = Math.min(result, dp['o' - 'a'] / 2);
        result = Math.min(result, dp['n' - 'a'] / 1);

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maxNumberOfBalloons("nlaebolko"));
    }
}
