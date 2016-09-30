package WordBreakTwo;

import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

    Return all such possible sentences.

    For example, given
    s = "catsanddog",
    dict = ["cat", "cats", "and", "sand", "dog"].

    A solution is ["cats and dog", "cat sand dog"].

 * Created by aoshen on 4/19/16.
 */
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> results = new ArrayList<String>();

        if (s == null || s.length() == 0 || wordDict == null || wordDict.isEmpty()) {
            return results;
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

        dfs(results, "", 0, flags, wordDict, s);

        return results;
    }

    public void dfs(List<String> results, String result, int start, boolean[] flags, Set<String> wordDict, String s) {
        if (start == s.length()) {
            results.add(result.trim());
            return;
        }

        for (int i = start + 1;i <= s.length();++ i) {
            if (wordDict.contains(s.substring(start, i)) && flags[i]) {
                dfs(results, result + s.substring(start, i) + " ", i, flags, wordDict, s);
            }
        }
    }
}
