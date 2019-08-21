package LongestStringChain;

import java.util.*;

/**
 * Given a list of words, each word consists of English lowercase letters.

 Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

 A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

 Return the longest possible length of a word chain with words chosen from the given list of words.



 Example 1:

 Input: ["a","b","ba","bca","bda","bdca"]
 Output: 4
 Explanation: one of the longest word chain is "a","ba","bda","bdca".
 */
public class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int max = 1;

        Map<String, Integer> mapping = new HashMap<>();

        for (String word : words) {
            mapping.put(word, 1);
        }

        for (String word : words) {
            for (int i = 0;i < word.length();++ i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                mapping.put(word, Math.max(mapping.get(word), mapping.getOrDefault(prev, 0) + 1));
                max = Math.max(max, mapping.get(word));
            }
        }

        return max;
    }
}
