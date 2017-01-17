package ConcatenatedWords;

import java.util.*;

/**
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

 A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 Example:
 Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

 Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

 Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 Note:
 The number of elements of the given array will not exceed 10,000
 The length sum of elements in the given array will not exceed 600,000.
 All the input string will only include lower case letters.
 The returned elements order does not matter.

 * Created by aoshen on 12/26/16.
 */
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> results = new ArrayList<>();
        Set<String> set = new HashSet<>();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0;i < words.length;++ i) {
            if (canForm(words[i], set)) {
                results.add(words[i]);
            }

            set.add(words[i]);
        }

        return results;
    }

    private boolean canForm(String word, Set<String> set) {
        if (set.isEmpty()) return false;
        boolean[] flags = new boolean[word.length() + 1];
        flags[0] = true;

        for (int i = 1;i <= word.length();++ i) {
            for (int j = 0;j < i;++ j) {
                if (!flags[j]) continue;
                if (set.contains(word.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }

        return flags[word.length()];
    }
}
