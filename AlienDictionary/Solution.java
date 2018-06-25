package AlienDictionary;

import java.time.temporal.ChronoField;
import java.util.*;


/**
 * There is a new alien language which uses the latin alphabet.
 * However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary,
 * where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.

 For example,
 Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 Note:
 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.

 * Created by aoshen on 6/26/16.
 */
public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        initialize(words, graph, indegree);
        buildIndegree(words, graph, indegree);

        StringBuilder sb = new StringBuilder();
        buildTopologicalOrder(sb, graph, indegree);

        return sb.length() == indegree.size() ? sb.toString() : "";
    }

    private void initialize(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
        for (String word : words) {
            for (int i = 0;i < word.length();++ i) {
                Character c = word.charAt(i);

                if (graph.get(c) == null) {
                    graph.put(c, new HashSet<>());
                }

                if (indegree.get(c) == null) {
                    indegree.put(c, 0);
                }
            }
        }
    }

    private void buildIndegree(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
        Set<String> visited = new HashSet<>();

        for (int i = 0;i < words.length - 1;++ i) {
            String curr = words[i];
            String next = words[i + 1];

            for (int j = 0;j < curr.length() && j < next.length();++ j) {
                Character from = curr.charAt(j);
                Character to = next.charAt(j);
                String edge = String.valueOf(from) + String.valueOf(to);

                if (from == to) continue;
                if (visited.contains(edge)) continue;

                graph.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
                visited.add(edge);
                break;
            }
        }
    }

    private void buildTopologicalOrder(StringBuilder sb, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
        Queue<Character> queue = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Character top = queue.poll();
            sb.append(top);

            for (Character c : graph.get(top)) {
                int degree = indegree.get(c);
                degree --;
                indegree.put(c, degree);

                if (degree == 0) {
                    queue.add(c);
                }
            }
        }
    }
}
