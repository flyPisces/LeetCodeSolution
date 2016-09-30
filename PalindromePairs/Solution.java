package PalindromePairs;

import java.util.*;

/**
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

    Example 1:
    Given words = ["bat", "tab", "cat"]
    Return [[0, 1], [1, 0]]
    The palindromes are ["battab", "tabbat"]
    Example 2:
    Given words = ["abcd", "dcba", "lls", "s", "sssll"]
    Return [[0, 1], [1, 0], [3, 2], [2, 4]]
    The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 * Created by aoshen on 5/29/16.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (null == words || words.length < 2) {
            return results;
        }

        for (int i = 0;i < words.length;++ i) {
            for (int j = 0;j < words.length;++ j) {
                if (i != j && isPanlindrome(words[i], words[j])) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    results.add(result);
                }
            }
        }

        return results;
    }

    private boolean isPanlindrome(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        int i = 0;
        int j = str2.length() - 1;

        while (i < str1.length() && j >= 0) {
            if (str1.charAt(i) != str2.charAt(j)) {
                return false;
            }

            ++ i;
            -- j;
        }

        if (str1.length() > str2.length()) {
            j = str1.length() - 1;

            while (i < j) {
                if (str1.charAt(i) != str1.charAt(j)) {
                    return false;
                }
                i ++;
                j --;
            }
        } else if (str1.length() < str2.length()) {
            i = 0;

            while (i < j) {
                if (str2.charAt(i) != str2.charAt(j)) {
                    return false;
                }

                ++ i;
                j --;
            }
        }

        return true;
    }
}
