package LongestCommonPrefix;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by aoshen on 7/6/16.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLength > str.length()) {
                minLength = str.length();
            }
        }

        for (int i = 0;i < minLength;++ i) {
            for (int j = 0;j < strs.length - 1;++ j) {
                String str1 = strs[j];
                String str2 = strs[j + 1];

                if (str1.charAt(i) != str2.charAt(i)) {
                    return str1.substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLength);
    }
}
