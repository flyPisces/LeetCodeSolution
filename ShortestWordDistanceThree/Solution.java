package ShortestWordDistanceThree;

import java.util.*;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

    word1 and word2 may be the same and they represent two individual words in the list.

    For example,
    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

    Given word1 = “makes”, word2 = “coding”, return 1.
    Given word1 = "makes", word2 = "makes", return 3.

    Note:
    You may assume word1 and word2 are both in the list.

 * Created by aoshen on 7/13/16.
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, inc = (word1.equals(word2)) ? 1 : 0, turn = 0, diff = Integer.MAX_VALUE;

        for (int i = 0;i < words.length;++ i) {
            if (words[i].equals(word1) && turn % 2 == 0) {
                idx1 = i;
                if (idx2 != -1) diff = Math.min(diff, Math.abs(idx2 - idx1));
                turn += inc;
            } else if (words[i].equals(word2)) {
                idx2 = i;
                if (idx1 != -1) diff = Math.min(diff, Math.abs(idx2 - idx1));
                turn += inc;
            }
        }

        return diff;
    }
}
