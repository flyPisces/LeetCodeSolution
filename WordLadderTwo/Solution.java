package WordLadderTwo;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

    Only one letter can be changed at a time
    Each intermediate word must exist in the word list
    For example,

    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Return
    [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
    ]

    Note:
    All words have the same length.
    All words contain only lowercase alphabetic characters.

 * Created by aoshen on 7/3/16.
 */
public class Solution {

    private int levels = -1;
    private Map<String, Integer> wordLevelMap = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> results = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Map<Integer, Set<String>> levelStringMap = new HashMap<>();
        Map<String, Set<String>> neighbors = new HashMap<>();

        wordList.add(beginWord);
        wordList.add(endWord);

        visited.add(beginWord);
        levelStringMap.put(1, new HashSet<>(visited));

        levels = buildBFSLevelMap(visited, neighbors, levelStringMap, wordList, endWord, 1);
        if (levels == -1) {
            return results;
        }

        buildWordLevelMap(levelStringMap);
        buildResults(neighbors, new ArrayList<String>(), results, 1, beginWord, endWord);
        return results;
    }

    private void buildWordLevelMap(Map<Integer, Set<String>> levelStringMap) {
        for (Map.Entry<Integer, Set<String>> entry : levelStringMap.entrySet()) {
            int level = entry.getKey();
            Set<String> words = entry.getValue();
            for (String word : words) {
                wordLevelMap.put(word, level);
            }
        }
    }

    private void buildResults(Map<String, Set<String>> neighbors, List<String> result, List<List<String>> results,
                              int currLevel, String currWord, String endWord) {
        if (levels == currLevel && endWord.equals(currWord)) {
            result.add(currWord);
            results.add(new ArrayList<>(result));
            result.remove(result.size() - 1);
            return;
        }

        if (wordLevelMap.get(currWord) == null || wordLevelMap.get(currWord) != currLevel) {
            return;
        }

        result.add(currWord);

        if (neighbors.get(currWord) != null) {
            for (String neighborWord : neighbors.get(currWord)) {
                buildResults(neighbors, result, results, currLevel + 1, neighborWord, endWord);
            }
        }

        result.remove(result.size() - 1);
    }

    private int buildBFSLevelMap(Set<String> visited, Map<String, Set<String>> neighbors, Map<Integer, Set<String>> levelStringMap,
                                 Set<String> wordList, String endWord, int currLevel) {

        if (levelStringMap.get(currLevel).contains(endWord)) {
            return currLevel;
        }

        if (levelStringMap.get(currLevel).isEmpty()) {
            return -1;
        }

        Set<String> curLevelStrSet = levelStringMap.get(currLevel);
        Set<String> nextLevelStrSet = new HashSet<>();

        for (String word : curLevelStrSet) {
            getStringNeightbors(word, neighbors, wordList, nextLevelStrSet, visited);
        }

        levelStringMap.put(currLevel + 1, new HashSet<>(nextLevelStrSet));
        visited.addAll(nextLevelStrSet);

        return buildBFSLevelMap(visited, neighbors, levelStringMap, wordList, endWord, currLevel + 1);
    }

    private void getStringNeightbors(String word, Map<String, Set<String>> neighborsMap, Set<String> wordList, Set<String> nextLevelStrSet,
                                     Set<String> visited) {
        for (int i = 0;i < word.length();++ i) {
            for (char c = 'a';c <= 'z';++ c) {
                if (word.charAt(i) == c) continue;

                char[] arr = word.toCharArray();
                arr[i] = c;
                String newWord = new String(arr);

                if (wordList.contains(newWord) && !visited.contains(newWord)) {
                    Set<String> neighbors = neighborsMap.get(word);
                    if (neighbors == null) {
                        neighbors = new HashSet<>();
                    }
                    neighbors.add(newWord);
                    neighborsMap.put(word, neighbors);
                    nextLevelStrSet.add(newWord);
                }
            }
        }
    }
}
