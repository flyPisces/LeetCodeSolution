package WordBreak;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
 *
 * Created by aoshen on 4/19/16.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        boolean[] flags = new boolean[s.length() + 1];
        flags[s.length()] = true;

        for (int i = s.length() - 1;i >= 0;-- i) {
            for (int j = i + 1;j <= s.length();++ j) {
                if (wordDict.contains(s.substring(i, j)) && flags[j] == true) {
                    flags[i] = true;
                    break;
                }
            }
        }

        return flags[0];
    }
}

