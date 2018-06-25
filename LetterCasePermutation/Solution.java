package LetterCasePermutation;

import java.util.*;

/**
 * Given a string S, we can transform every letter individually to be lowercase or
 * uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 */
public class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null) {
            return new LinkedList<String>();
        }

        LinkedList<String> results = new LinkedList<>();
        results.add(S);

        for (int i = 0;i < S.length();++ i) {
            if (Character.isDigit(S.charAt(i))) continue;

            int size = results.size();
            for (int j = 0;j < size;++ j) {
                String curr = results.poll();
                char[] arr = curr.toCharArray();

                arr[i] = Character.toLowerCase(arr[i]);
                results.add(new String(arr));

                arr[i] = Character.toUpperCase(arr[i]);
                results.add(new String(arr));
            }
        }

        return results;
    }
}
