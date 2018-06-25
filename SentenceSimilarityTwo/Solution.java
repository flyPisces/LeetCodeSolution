package SentenceSimilarityTwo;

import java.util.*;

/**
 * Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

 For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

 Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.

 Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

 Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

 Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 */
public class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;

        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs) {
            String parent1 = find(map, pair[0]), parent2 = find(map, pair[1]);
            if (!parent1.equals(parent2)) map.put(parent1, parent2);
        }

        for (int i = 0;i < words1.length;++ i) {
            if (!words1[i].equals(words2[i]) && !find(map, words1[i]).equals(find(map, words2[i]))) {
                return false;
            }
        }

        return true;
    }

    private String find(Map<String, String> map, String s) {
        if (!map.containsKey(s)) map.put(s, s);
        return s.equals(map.get(s)) ? s : find(map, map.get(s));
    }
}
