package FirstUniqueCharacterinaString;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 Note: You may assume the string contain only lowercase letters.

 * Created by aoshen on 8/24/16.
 */
public class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;

        int[] dp = new int[256];
        for (int i = 0;i < s.length();++ i) {
            dp[s.charAt(i)] ++;
        }

        for (int i = 0;i < s.length();++ i) {
            if (dp[s.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
