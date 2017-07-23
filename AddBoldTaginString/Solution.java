package AddBoldTaginString;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to
 * wrap the substrings in s that exist in dict.
 *
 * If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag.
 * Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

 Example 1:
 Input:
 s = "abcxyz123"
 dict = ["abc","123"]
 Output:
 "<b>abc</b>xyz<b>123</b>"
 Example 2:
 Input:
 s = "aaabbcc"
 dict = ["aaa","aab","bc"]
 Output:
 "<b>aaabbc</b>c"

 * Created by aoshen on 6/29/17.
 */
public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] dp = new boolean[s.length()];

        for (int i = 0, end = 0;i < s.length();++ i) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            dp[i] = end > i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < s.length();++ i) {
            if (!dp[i]) {
                sb.append(s.charAt(i));
                continue;
            }

            int j = i;
            while (j < s.length() && dp[j]) j ++;
            sb.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }

        return sb.toString();
    }
}
