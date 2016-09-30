package ShortestWordDistanceTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

    Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

    For example,
    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

    Given word1 = “coding”, word2 = “practice”, return 3.
    Given word1 = "makes", word2 = "coding", return 1.

 *  Created by aoshen on 7/12/16.
 */
public class WordDistance {

    private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {

        int index = 0;

        for (String word : words) {
            List<Integer> positions = map.get(word);

            if (null == positions) {
                positions = new ArrayList<>();
            }
            positions.add(index);

            map.put(word, positions);
            index ++;
        }

    }

    public int shortest(String word1, String word2) {
        int diff = Integer.MAX_VALUE;

        List<Integer> word1Indices = map.get(word1);
        List<Integer> word2Indices = map.get(word2);

        int i = 0, j = 0;
        while (i < word1Indices.size() && j < word2Indices.size()) {
            if (word1Indices.get(i) < word2Indices.get(j)) {
                diff = Math.min(diff, word2Indices.get(j) - word1Indices.get(i));
                ++ i;
            } else {
                diff = Math.min(diff, word1Indices.get(i) - word2Indices.get(j));
                ++ j;
            }
        }

        return diff;
    }
}
