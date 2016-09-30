package ValidAnagram;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.

    For example,
    s = "anagram", t = "nagaram", return true.
    s = "rat", t = "car", return false.

    Note:
    You may assume the string contains only lowercase alphabets.

 * Created by aoshen on 4/7/16.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s != null && t != null && s.length() == t.length()) {
            int[] nums = new int[26];

            for (int i = 0;i != s.length();++ i) {
                nums[s.charAt(i) - 'a'] ++;
            }

            for (int i = 0;i != t.length();++ i) {
                nums[t.charAt(i) - 'a'] --;
            }

            for (int i = 0;i != 26;++ i) {
                if (nums[i] != 0) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
