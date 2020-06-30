package MinimumNumberofFrogsCroaking;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the string croakOfFrogs, which represents a combination of the string "croak" from different frogs, that is, multiple frogs can croak at the same time, so multiple “croak” are mixed. Return the minimum number of different frogs to finish all the croak in the given string.
 *
 * A valid "croak" means a frog is printing 5 letters ‘c’, ’r’, ’o’, ’a’, ’k’ sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of valid "croak" return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: croakOfFrogs = "croakcroak"
 * Output: 1
 * Explanation: One frog yelling "croak" twice.
 * Example 2:
 *
 * Input: croakOfFrogs = "crcoakroak"
 * Output: 2
 * Explanation: The minimum number of frogs is two.
 * The first frog could yell "crcoakroak".
 * The second frog could yell later "crcoakroak".
 * Example 3:
 *
 * Input: croakOfFrogs = "croakcrook"
 * Output: -1
 * Explanation: The given string is an invalid combination of "croak" from different frogs.
 * Example 4:
 *
 * Input: croakOfFrogs = "croakcroa"
 * Output: -1
 */
public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('c', 0);
        mapping.put('r', 1);
        mapping.put('o', 2);
        mapping.put('a', 3);
        mapping.put('k', 4);

        int[] count = new int[5];
        int maxResult = 0 , result = 0;

        for (char c : croakOfFrogs.toCharArray()) {
            int idx = mapping.get(c);
            ++ count[idx];

            if (idx == 0) {
                maxResult = Math.max(maxResult, ++ result);
            } else if (count[idx - 1] == 0) return -1;
            else if (idx == 4) {
                -- result;
            }

            --count[(idx - 1 + 5) % 5];
        }

        return result == 0 ? maxResult : -1;

    }
}
