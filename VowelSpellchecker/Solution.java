package VowelSpellchecker;

import java.util.*;

/**
 * Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

 For a given query word, the spell checker handles two categories of spelling mistakes:

 Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
 Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
 Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
 Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
 Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
 In addition, the spell checker operates under the following precedence rules:

 When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
 When the query matches a word up to capitlization, you should return the first such match in the wordlist.
 When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
 If the query has no matches in the wordlist, you should return the empty string.
 Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].



 Example 1:

 Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 */
public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> sets = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowels = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String vowel = lower.replaceAll("[aeiou]", "#");

            cap.putIfAbsent(lower, word);
            vowels.putIfAbsent(vowel, word);
        }

        for (int i = 0;i < queries.length;++ i) {
            if (sets.contains(queries[i])) continue;

            String lower = queries[i].toLowerCase();
            String vowel = lower.replaceAll("[aeiou]", "#");

            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowels.containsKey(vowel)) {
                queries[i] = vowels.get(vowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.spellchecker(new String[] {"KiTe","kite","hare","Hare"},
                new String[] {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"}));
    }
}
