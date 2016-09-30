package LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lenOfLongestSubstring = 0;
        
        if (s == null) {
            lenOfLongestSubstring = 0;
        } else if (s.length() <= 1) {
            lenOfLongestSubstring = s.length();
        } else {
            int prev = 0;
            boolean[] letters = new boolean[256];
            
            for (int i = 0;i != s.length();++ i) {
                if (!letters[s.charAt(i)]) {
                    letters[s.charAt(i)] = true;
                } else {
                    while (s.charAt(prev) != s.charAt(i)) {
                        letters[s.charAt(prev)] = false;
                        prev ++;
                    }
                    prev ++;
                }
                
                lenOfLongestSubstring = Math.max(lenOfLongestSubstring, i - prev + 1);
            }
        }
        
        return lenOfLongestSubstring;
    }
}
