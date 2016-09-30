package WordPatternTwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Given a pattern and a string str, find if str follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

    Examples:
    pattern = "abab", str = "redblueredblue" should return true.
    pattern = "aaaa", str = "asdasdasdasd" should return true.
    pattern = "aabb", str = "xyzabcxzyabc" should return false.

    Notes:
    You may assume both pattern and str contains only lowercase letters.

 *  Created by aoshen on 7/7/16.
 */
public class Solution {

    Map<Character, String> patternCharactorMapping = new HashMap<>();
    Set<String> visited = new HashSet<>();
    boolean res = false;

    public boolean wordPatternMatch(String pattern, String str) {
        helper(pattern, str, 0, 0);
        return res;
    }

    public void helper(String pattern, String str, int pIndex, int sIndex) {
        if (pIndex == pattern.length() && sIndex == str.length()) {
            res = true;
            return;
        }

        if (pIndex >= pattern.length() || sIndex >= str.length()) {
            return;
        }

        char c = pattern.charAt(pIndex);

        for (int j = sIndex + 1;j <= str.length();++ j) {
            if (!patternCharactorMapping.containsKey(c) && !visited.contains(str.substring(sIndex, j))) {
                patternCharactorMapping.put(c, str.substring(sIndex, j));
                visited.add(str.substring(sIndex, j));
                helper(pattern, str, pIndex + 1, j);
                visited.remove(str.substring(sIndex, j));
                patternCharactorMapping.remove(c);
            } else if (patternCharactorMapping.containsKey(c) && patternCharactorMapping.get(c).equals(str.substring(sIndex, j))) {
                helper(pattern, str, pIndex + 1, j);
            }
        }
    }
}
