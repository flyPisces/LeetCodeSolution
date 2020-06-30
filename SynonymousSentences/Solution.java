package SynonymousSentences;

import java.util.*;

/**
 * Given a list of pairs of equivalent words synonyms and a sentence text, Return all possible synonymous sentences sorted lexicographically.
 *
 *
 * Example 1:
 *
 * Input:
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * Output:
 * ["I am cheerful today but was sad yesterday",
 * ​​​​​​​"I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 */
public class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> synonymsMap = new HashMap<>();

        for (List<String> synonym : synonyms) {
            String str1 = synonym.get(0), str2 = synonym.get(1);
            synonymsMap.putIfAbsent(str1, new LinkedList<>());
            synonymsMap.putIfAbsent(str2, new LinkedList<>());
            synonymsMap.get(str1).add(str2);
            synonymsMap.get(str2).add(str1);
        }

        TreeSet<String> treeSet = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(text);

        while (!queue.isEmpty()) {
            String result = queue.poll();
            treeSet.add(result);

            String[] splits = result.split("\\s");
            for (int i = 0;i < splits.length;++ i) {
                if (!synonymsMap.containsKey(splits[i])) continue;
                for (String word: synonymsMap.get(splits[i])) {
                    splits[i] = word;
                    String newWord = String.join(" ", splits);
                    if (treeSet.add(newWord)) {
                        queue.offer(newWord);
                    }
                }
            }
        }

        return new ArrayList<>(treeSet);
    }
}
