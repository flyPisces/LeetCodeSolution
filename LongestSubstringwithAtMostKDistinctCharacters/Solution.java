package LongestSubstringwithAtMostKDistinctCharacters;

import java.util.*;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = “eceba” and k = 2,

 T is "ece" which its length is 3.

 * Created by aoshen on 6/26/16.
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int start = 0;

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0;i < s.length();++ i) {

            char curr = s.charAt(i);

            if (charCountMap.containsKey(curr)) {
                charCountMap.put(curr, charCountMap.get(curr) + 1);
            } else {
                charCountMap.put(curr, 1);

                while (charCountMap.size() > k) {
                    char first = s.charAt(start++);
                    int count = charCountMap.get(first);

                    if (count == 1) {
                        charCountMap.remove(first);
                    } else {
                        charCountMap.put(first, count - 1);
                    }
                }
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }
}
