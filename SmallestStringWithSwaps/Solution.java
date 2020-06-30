package SmallestStringWithSwaps;

import java.util.*;

/**
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 *
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 *
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 *
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 *
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 */
public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] dp = new int[s.length()];

        for (int i = 0;i < s.length();++ i) dp[i] = i;
        for (List<Integer> pair : pairs) {
            union(dp, pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for (int i = 0;i < s.length();++ i) {
            int root = find(dp, i);

            List<Integer> groups = mapping.getOrDefault(root, new ArrayList<>());
            groups.add(i);
            mapping.put(root, groups);
        }

        char[] arr = s.toCharArray();
        for (Map.Entry<Integer, List<Integer>> entry : mapping.entrySet()) {
            List<Integer> groups = entry.getValue();
            List<Character> chars = new ArrayList<>();

            for (int idx : groups) {
                chars.add(arr[idx]);
            }
            Collections.sort(chars);

            for (int i = 0;i < groups.size();++ i) {
                arr[groups.get(i)] = chars.get(i);
            }
        }

        return new String(arr);
    }

    private void union(int[] dp, int a, int b) {
        int aRoot = find(dp, a);
        int bRoot = find(dp, b);

        if (aRoot != bRoot) {
            dp[aRoot] = bRoot;
        }
    }

    private int find(int[] dp, int node) {
        if (dp[node] == node) return node;

        return dp[node] = find(dp, dp[node]);
    }
}
