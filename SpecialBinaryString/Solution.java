package SpecialBinaryString;

import java.util.*;

/**
 * Special binary strings are binary strings with the following two properties:

 The number of 0's is equal to the number of 1's.
 Every prefix of the binary string has at least as many 1's as 0's.
 Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S,
 and swapping them. (Two strings are consecutive
 if the last character of the first string is exactly one index before the first character of the second string.)

 At the end of any number of moves, what is the lexicographically largest resulting string possible?

 Example 1:
 Input: S = "11011000"
 Output: "11100100"
 Explanation:
 The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
 This is the lexicographically largest string possible after some number of swaps.
 */
public class  Solution {
    public String makeLargestSpecial(String S) {
        List<String> results = new ArrayList<>();

        int count = 0, start = 0;
        for (int i = 0;i < S.length();++ i) {
            if (S.charAt(i) == '1') {
                count ++;
            } else {
                count --;
            }

            if (count == 0) {
                results.add("1" + makeLargestSpecial(S.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }

        Collections.sort(results, Collections.reverseOrder());
        return String.join("", results);
    }
}
