package FindtheLongestSubstringContainingVowelsinEvenCounts;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
 * Example 2:
 *
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * Example 3:
 *
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        int result = 0, state = 0;
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('a', 1);
        mapping.put('e', 2);
        mapping.put('i', 4);
        mapping.put('o', 8);
        mapping.put('u', 16);

        Map<Integer, Integer> stateIdxMap = new HashMap<>();
        stateIdxMap.put(state, -1);

        int idx = 0;
        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                state = state ^ mapping.get(c);
            }
            stateIdxMap.putIfAbsent(state, idx);
            result = Math.max(result, idx - stateIdxMap.get(state));

            idx ++;
        }

        return result;
    }
}
