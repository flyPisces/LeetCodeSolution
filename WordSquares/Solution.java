package WordSquares;

import java.util.*;


/**
 * Given a set of words (without duplicates), find all word squares you can build from them.

 A sequence of words forms a valid word square if the kth row and column read the exact same string,
 where 0 ≤ k < max(numRows, numColumns).

 For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word
 reads the same both horizontally and vertically.

 b a l l
 a r e a
 l e a d
 l a d y
 Note:
 There are at least 1 and at most 1000 words.
 All words will have the exact same length.
 Word length is at least 1 and at most 5.
 Each word contains only lowercase English alphabet a-z.
 Example 1:

 Input:
 ["area","lead","wall","lady","ball"]

 Output:
 [
 [ "wall",
 "area",
 "lead",
 "lady"
 ],
 [ "ball",
 "area",
 "lead",
 "lady"
 ]
 ]

 Explanation:
 The output consists of two word squares.
 The order of output does not matter (just the order of words in each word square matters).
 Example 2:

 Input:
 ["abat","baba","atan","atal"]

 Output:
 [
 [ "baba",
 "abat",
 "baba",
 "atan"
 ],
 [ "baba",
 "abat",
 "baba",
 "atal"
 ]
 ]

 Explanation:
 The output consists of two word squares.
 The order of output does not matter (just the order of words in each word square matters).

 * Created by aoshen on 10/16/16.
 */
public class
Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> results = new ArrayList<>();

        int len1 = words.length;
        int len2 = words[0].length();
        Map<Character, List<String>> hm = new HashMap<>();

        for (int i = 0;i < len1;++ i) {
            char c = words[i].charAt(0);

            List<String> strs = hm.get(c);
            if (strs == null) {
                strs = new ArrayList<>();
            }
            strs.add(words[i]);
            hm.put(c, strs);
        }

        for (int i = 0;i < len1;++ i) {
            String[] currs = new String[len2];
            currs[0] = words[i];
            helper(1, currs, hm, len2, results);
        }
        return results;
    }

    private void helper(int index, String[] currs, Map<Character, List<String>> hm, int len2, List<List<String>> results) {
        if (index == len2) {
            results.add(new ArrayList<>(Arrays.asList(currs)));
            return;
        }

        char x = currs[0].charAt(index);
        if (!hm.containsKey(x)) return;
        for (String str : hm.get(x)) {
            if (matches(str, index, currs)) {
                currs[index] = str;
                helper(index + 1, currs, hm, len2, results);
            }
        }
    }

    private boolean matches(String str, int end, String[] currs) {
        for (int i = 1;i < end;++ i) {
            if (str.charAt(i) != currs[i].charAt(end)) return false;
        }

        return true;
    }
}
