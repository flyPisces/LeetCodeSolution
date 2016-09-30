package RepeatedDNASequences;

import java.util.*;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * Created by aoshen on 5/26/16.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();

        if (s == null || s.length() < 10) {
            return results;
        }

        Map<String, Integer> mapping = new HashMap<>();

        for (int i = 0;i <= s.length() - 10;++ i) {
            String subStr = s.substring(i, i + 10);

            if (mapping.containsKey(subStr)) {
                if (mapping.get(subStr) == 1) {
                    results.add(subStr);
                }

                mapping.put(subStr, 2);
            } else {
                mapping.put(subStr, 1);
            }
        }

        return results;
    }

}
