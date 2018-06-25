package AmbiguousCoordinates;

import java.util.*;

/**
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.

 Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

 The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

 Example 1:
 Input: "(123)"
 Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 Example 2:
 Input: "(00011)"
 Output:  ["(0.001, 1)", "(0, 0.011)"]
 Explanation:
 0.0, 00, 0001 or 00.01 are not allowed.
 Example 3:
 Input: "(0123)"
 Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 Example 4:
 Input: "(100)"
 Output: [(10, 0)]
 Explanation:
 1.0 is not allowed.
 */
public class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> results = new ArrayList<>();
        int len = S.length();

        for (int i = 1;i < len - 2;++ i) {
            List<String> resultsA = f(S.substring(1, i + 1));
            List<String> resultsB = f(S.substring(i + 1, len - 1));

            for (String str1 : resultsA) {
                for (String str2 : resultsB) {
                    results.add("(" + str1 + ", " + str2 + ")");
                }
            }
        }

        return results;
    }

    private List<String> f(String S) {
        int len = S.length();
        List<String> res = new ArrayList<>();

        if (len == 0 || (len > 1 && S.charAt(0) == '0' && S.charAt(len - 1) == '0')) {
            return res;
        }

        if (len > 1 && S.charAt(0) == '0') {
            res.add("0." + S.substring(1));
            return res;
        }

        res.add(S);
        if (len == 1 || S.charAt(len - 1) == '0') return res;
        for (int i = 1;i < len;++ i) {
            res.add(S.substring(0, i) + "." + S.substring(i));
        }

        return res;
    }
}
