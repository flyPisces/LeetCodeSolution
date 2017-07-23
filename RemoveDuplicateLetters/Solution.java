package RemoveDuplicateLetters;

import java.util.*;

/**
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.

    Example:
    Given "bcabc"
    Return "abc"

    Given "cbacdcbc"
    Return "acdb"

 * Created by aoshen on 5/30/16.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();++ i) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        StringBuilder sb = new StringBuilder();
        int start = 0;

        while (!map.isEmpty()) {
            int end = getSmallestIndex(map);

            char curr = 'z' + 1;
            for (int i = start;i <= end;++ i) {
                if (s.charAt(i) < curr && map.containsKey(s.charAt(i))) {
                    curr = s.charAt(i);
                    start = i;
                }
            }

            sb.append(curr);
            map.remove(curr);

            start = start + 1;
        }

        return sb.toString();
    }

    private int getSmallestIndex(Map<Character, Integer> map) {
        int min_Index = Integer.MAX_VALUE;

        for (Integer index : map.values()) {
            if (index < min_Index) {
                min_Index = index;
            }
        }

        return min_Index;
    }
}
