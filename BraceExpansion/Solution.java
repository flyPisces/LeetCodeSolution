package BraceExpansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A string S represents a list of words.
 *
 * Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.  If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].
 *
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
 *
 * Return all words that can be formed in this manner, in lexicographical order.
 *
 *
 *
 * Example 1:
 *
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 * Example 2:
 *
 * Input: "abcd"
 * Output: ["abcd"]
 */
public class Solution {
    public String[] expand(String S) {
        List<String> results = new ArrayList<>();

        if (S.isEmpty()) {
            return new String[] {""};
        } else if (S.length() == 1) {
            return new String[] { S };
        } else {
            if (S.charAt(0) == '{') {
                int i = 0;
                while (S.charAt(i) != '}') {
                    ++ i;
                }

                String[] lsplits = S.substring(1, i).split(",");
                String[] rsplits = expand(S.substring(i + 1));

                for (String lStr : lsplits) {
                    for (String rStr : rsplits) {
                        results.add(lStr + rStr);
                    }
                }
            } else {
                String[] splits = expand(S.substring(1));

                for (String str : splits) {
                    results.add(S.charAt(0) + str);
                }
            }
        }

        Collections.sort(results);

        return results.toArray(new String[0]);
    }
}
