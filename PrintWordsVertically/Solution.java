package PrintWordsVertically;

import java.util.*;

/**
 * Given a string s. Return all the words vertically in the same order in which they appear in s.
 * Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
 * Each word would be put on only one column and that in one column there will be only one word.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "HOW ARE YOU"
 * Output: ["HAY","ORO","WEU"]
 * Explanation: Each word is printed vertically.
 *  "HAY"
 *  "ORO"
 *  "WEU"
 * Example 2:
 *
 * Input: s = "TO BE OR NOT TO BE"
 * Output: ["TBONTB","OEROOE","   T"]
 * Explanation: Trailing spaces is not allowed.
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * Example 3:
 *
 * Input: s = "CONTEST IS COMING"
 * Output: ["CIC","OSO","N M","T I","E N","S G","T"]
 */
public class Solution {
    public List<String> printVertically(String s) {
        int max = 0;
        String[] splits = s.split(" ");

        for (String split : splits) {
            max = Math.max(max, split.length());
        }

        List<String> results = new ArrayList<>();
        for (int i = 0;i < max;++ i) {
            StringBuilder sb = new StringBuilder();

            for (String split : splits) {
                sb.append(i < split.length() ? split.charAt(i) : ' ');
            }

            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            results.add(sb.toString());
        }

        return results;
    }
}
