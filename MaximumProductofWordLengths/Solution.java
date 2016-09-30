package MaximumProductofWordLengths;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.

 * Created by aoshen on 6/7/16.
 */
public class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        int len = words.length;
        int[] elements = new int[len];
        for (int i = 0;i < len;++ i) {
            for (int j = 0;j < words[i].length();++ j) {
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        for (int i = 0;i < len;++ i) {
            for (int j = i + 1;j < len;++ j) {
                if ((elements[i] & elements[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }
}
