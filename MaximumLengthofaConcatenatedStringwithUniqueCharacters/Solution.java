package MaximumLengthofaConcatenatedStringwithUniqueCharacters;

import java.util.*;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */
public class Solution {
    public int maxLength(List<String> arr) {
        int result = 0;
        List<Integer> temp = new ArrayList<>();
        temp.add(0);

        for (String str : arr) {
            int dup = 0, or = 0;

            for (char c : str.toCharArray()) {
                dup |= or & (1 << (c - 'a'));
                or |= 1 << (c - 'a');
            }

            if (dup > 0) continue;

            for (int j = temp.size() - 1;j >= 0;-- j) {
                if ((temp.get(j) & or) > 0) continue;
                temp.add(temp.get(j) | or);
                result = Math.max(result, Integer.bitCount(temp.get(j) | or));
            }
        }

        return result;
    }
}
