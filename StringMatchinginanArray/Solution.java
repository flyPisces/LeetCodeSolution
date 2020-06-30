package StringMatchinginanArray;

import java.util.*;

/**
 * Given an array of string words. Return all strings in words which is substring of another word in any order.
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 *
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 *
 * Input: words = ["blue","green","bu"]
 * Output: []
 */
public class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();

        Arrays.sort(words, (a, b) -> (a.length() - b.length()));

        for (int i = 0;i < words.length;++ i) {
            for (int j = 0;j < i;++ j) {
                if (words[i].indexOf(words[j]) != -1) {
                    set.add(words[j]);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
