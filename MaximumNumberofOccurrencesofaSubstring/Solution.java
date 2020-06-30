package MaximumNumberofOccurrencesofaSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return the maximum number of ocurrences of any substring under the following rules:
 *
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 *
 *
 * Example 1:
 *
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 * Example 2:
 *
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 * Example 3:
 *
 * Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * Output: 3
 * Example 4:
 *
 * Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * Output: 0
 */
public class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> subStringCntMapping = new HashMap<>();
        Map<Character, Integer> tempCntMapping = new HashMap<>();

        for (int i = 0;i < s.length();++ i) {
            tempCntMapping.clear();
            int distCnt = 0;
            for (int j = 0;j < maxSize;++ j) {
                if (i + j >= s.length()) break;
                tempCntMapping.put(s.charAt(i + j), tempCntMapping.getOrDefault(s.charAt(i + j), 0) + 1);

                if (tempCntMapping.get(s.charAt(i + j)) == 1) distCnt ++;
                if (distCnt > maxLetters) break;
                if (j >= minSize - 1) {
                    subStringCntMapping.put(s.substring(i, i + j + 1), subStringCntMapping.getOrDefault(s.substring(i, i + j + 1), 0) + 1);
                }
            }
        }

        int result = 0;
        for (int num : subStringCntMapping.values()) {
            result = Math.max(result, num);
        }

        return result;
    }
}
