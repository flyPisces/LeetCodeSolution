package NumberofValidWordsforEachPuzzle;

import java.util.*;

/**
 * With respect to a given puzzle string, a word is valid if both the following conditions are satisfied:
 * word contains the first letter of puzzle.
 * For each letter in word, that letter is in puzzle.
 * For example, if the puzzle is "abcdefg", then valid words are "faced", "cabbage", and "baggage"; while invalid words are "beefed" (doesn't include "a") and "based" (includes "s" which isn't in the puzzle).
 * Return an array answer, where answer[i] is the number of words in the given word list words that are valid with respect to the puzzle puzzles[i].
 *
 *
 * Example :
 *
 * Input:
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * Output: [1,1,3,2,4,0]
 * Explanation:
 * 1 valid word for "aboveyz" : "aaaa"
 * 1 valid word for "abrodyz" : "aaaa"
 * 3 valid words for "abslute" : "aaaa", "asas", "able"
 * 2 valid words for "absoryz" : "aaaa", "asas"
 * 4 valid words for "actresz" : "aaaa", "asas", "actt", "access"
 * There're no valid words for "gaswxyz" cause none of the words in the list contains letter 'g'.
 */
public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> bitMaskCounts = new HashMap<>();

        int mask = 0;
        for (String word : words) {
            mask = 0;

            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            bitMaskCounts.put(mask, bitMaskCounts.getOrDefault(mask, 0) + 1);
        }

        List<Integer> results = new ArrayList<>();

        for (String puzzle : puzzles) {
            int puzzleMask = 0;
            for (char c : puzzle.toCharArray()) {
                puzzleMask |= 1 << (c - 'a');
            }

                int sub = puzzleMask;
                int firstDigitMask = 1 << (puzzle.charAt(0) - 'a');
                int result = 0;

                while (sub > 0) {
                    if ((sub & firstDigitMask) > 0 && bitMaskCounts.containsKey(sub)) {
                        result += bitMaskCounts.get(sub);
                    }

                    sub = (sub - 1) & puzzleMask;
                }

                results.add(result);

        }

        return results;
    }
}
