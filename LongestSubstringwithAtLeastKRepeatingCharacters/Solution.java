package LongestSubstringwithAtLeastKRepeatingCharacters;

import com.apple.laf.AquaTreeUI;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the length of the longest substring T of a given string (consists of lowercase letters only)
 * such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

 * Created by aoshen on 9/6/16.
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0 || s.length() < k) return 0;
        if (s.length() == 1 && k == 1) return 1;
        Map<Character, Integer> mapping = new HashMap<>();

        for (int i = 0;i < s.length();++ i) {
            char c = s.charAt(i);

            if (mapping.containsKey(c)) {
                mapping.put(c, mapping.get(c) + 1);
            } else {
                mapping.put(c, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        char split = 'a';

        for (Map.Entry<Character, Integer> entry : mapping.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                split = entry.getKey();
            }
        }

        if (min >= k) return s.length();
        int len = 0;
        String[] splits = s.split(String.valueOf(split));
        for (String ss : splits) {
            len = Math.max(len, longestSubstring(ss, k));
        }

        return len;
    }
}
