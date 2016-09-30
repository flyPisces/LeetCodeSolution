package WordLadder;

import java.util.*;


/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the word list
    For example,

    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.
 *
 * Created by aoshen on 5/14/16.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int ladderLength = 1;

        if (beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty()
                || beginWord.length() != endWord.length() || wordList == null) {
            return 0;
        }

        if (beginWord.equals(endWord)) {
            return 0;
        }

        int curLevelNum = 1;
        int nextLevelNum = 0;
        LinkedList<String> bfsList = new LinkedList<>();
        bfsList.add(beginWord);
        wordList.remove(beginWord);


        while (!bfsList.isEmpty()) {
            String curStr = bfsList.poll();

            for (int i = 0; i != curStr.length();++ i) {
                char[] arr = curStr.toCharArray();
                for (char c = 'a';c <= 'z';++ c) {
                    arr[i] = c;
                    String next = new String(arr);

                    if (next.equals(endWord)) {
                        return ladderLength + 1;
                    }

                    if (wordList.contains(next)) {
                        bfsList.add(next);
                        wordList.remove(next);
                        nextLevelNum ++;
                    }
                }
            }
            curLevelNum --;

            if (curLevelNum == 0) {
                ladderLength++;
                curLevelNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }

        return 0;
    }
}
