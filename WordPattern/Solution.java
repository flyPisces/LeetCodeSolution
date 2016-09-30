package WordPattern;

import java.util.*;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * Created by aoshen on 5/27/16.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (null == pattern && str == null) {
            return true;
        }

        if (pattern == null || str == null) {
            return false;
        }

        Map<Character, String> mapping = new HashMap<>();
        Set<String> visitedStringSet = new HashSet<>();

        String[] splits = str.split(" ");

        if (splits.length != pattern.length()) {
            return false;
        }

        for (int i = 0;i != splits.length;++ i) {
            if (!mapping.containsKey(pattern.charAt(i)) && !visitedStringSet.contains(splits[i])) {
                visitedStringSet.add(splits[i]);
                mapping.put(pattern.charAt(i), splits[i]);
            } else if (mapping.get(pattern.charAt(i)) == null || !mapping.get(pattern.charAt(i)).equals(splits[i])) {
                return false;
            } else {
                continue;
            }
        }

        return true;
    }
}
