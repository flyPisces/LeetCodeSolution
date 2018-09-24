package UncommonWordsfromTwoSentences;

import java.util.*;

/**
 *
 We are given two sentences A and B.  (A sentence is a string of space separated words.
 Each word consists only of lowercase letters.)

 A word is uncommon if it appears exactly once in one of the sentences,
 and does not appear in the other sentence.

 Return a list of all uncommon words.

 You may return the list in any order.



 Example 1:

 Input: A = "this apple is sweet", B = "this apple is sour"
 Output: ["sweet","sour"]
 Example 2:

 Input: A = "apple apple", B = "banana"
 Output: ["banana"]
 */
public class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();

        String[] splits = A.split(" ");
        for (String split : splits) {
            map.put(split, map.getOrDefault(split, 0) + 1);
        }

        splits = B.split(" ");
        for (String split : splits) {
            map.put(split, map.getOrDefault(split, 0) + 1);
        }

        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                results.add(entry.getKey());
            }
        }

        return results.toArray(new String[results.size()]);
    }
}
