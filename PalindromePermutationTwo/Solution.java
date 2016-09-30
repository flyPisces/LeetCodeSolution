package PalindromePermutationTwo;

import java.util.*;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].

 * Created by aoshen on 8/5/16.
 */
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> resuls = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return resuls;
        }
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        String single = "";
        String candidate = "";
        boolean existed = false;


        for (int i = 0;i < s.length();++ i) {
            char ch = s.charAt(i);

            if (characterIntegerMap.get(ch) == null) {
                characterIntegerMap.put(ch, 1);
            } else {
                characterIntegerMap.put(ch, characterIntegerMap.get(ch) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: characterIntegerMap.entrySet()) {
            char ch = entry.getKey();
            int times = entry.getValue();

            for (int i = 0;i < times / 2;++ i) {
                candidate += ch;
            }

            if (times % 2 == 1) {
                if (existed == true) {
                    return resuls;
                } else {
                    existed = true;
                    single += ch;
                }
            }
        }

        if (candidate.isEmpty() && single != null) {
            resuls.add(single);
            return resuls;
        }

        recursive_helper("", candidate, single, resuls, candidate.length());

        return resuls;
    }

    private void recursive_helper(String left, String candidate, String single, List<String> results, int size) {
        if (left.length() == size) {
            String right = new StringBuilder(left).reverse().toString();
            results.add(left + single + right);
            return;
        }

        for (int i = 0;i < candidate.length();++ i) {
            char ch = candidate.charAt(i);
            if (i != 0 && candidate.charAt(i - 1) == candidate.charAt(i)) {
                continue;
            }

            recursive_helper(left + ch, candidate.substring(0, i) + candidate.substring(i + 1), single, results, size);
        }
    }
}
