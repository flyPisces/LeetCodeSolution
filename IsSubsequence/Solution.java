package IsSubsequence;

/**
 * Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 * Created by aoshen on 9/5/16.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (int i = 0;i < s.length();++ i) {
            int idx = t.indexOf(String.valueOf(s.charAt(i)), start);
            if (idx == -1) {
                return false;
            }
            start = idx + 1;
        }

        return true;
    }
}
