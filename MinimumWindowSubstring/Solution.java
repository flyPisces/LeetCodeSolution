package MinimumWindowSubstring;

import java.util.*;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 * Created by aoshen on 5/5/16.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        String result = "";

        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        for (int i = 0;i != t.length();++ i) {
            if (!dict.containsKey(t.charAt(i))) {
                dict.put(t.charAt(i), 1);
            } else {
                dict.put(t.charAt(i), dict.get(t.charAt(i)) + 1);
            }
        }

        int count = 0;
        int pre = 0;
        int minLen = s.length() + 1;

        for (int i = 0;i != s.length();++ i) {
            if (dict.containsKey(s.charAt(i))) {
                dict.put(s.charAt(i), dict.get(s.charAt(i)) - 1);

                if (dict.get(s.charAt(i)) >= 0) {
                    count++;
                }

                while (count == t.length()) {
                    if (dict.containsKey(s.charAt(pre))) {
                        dict.put(s.charAt(pre), dict.get(s.charAt(pre)) + 1);

                        if (dict.get(s.charAt(pre)) > 0) {
                            if (minLen > i - pre + 1) {
                                result = s.substring(pre, i + 1);
                                minLen = i - pre + 1;
                            }
                            count--;
                        }

                    }
                    pre++;
                }
            }
        }

        return result;
    }
}
