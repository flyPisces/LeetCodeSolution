package PositionsofLargeGroups;

import java.util.*;

/**
 *
 In a string S of lowercase letters, these letters form consecutive groups of the same character.

 For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

 Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

 The final answer should be in lexicographic order.



 Example 1:

 Input: "abbxxxxzzy"
 Output: [[3,6]]
 Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 Example 2:

 Input: "abc"
 Output: []
 Explanation: We have "a","b" and "c" but no large group.
 Example 3:

 Input: "abcdddeeeeaabbbcd"
 Output: [[3,5],[6,9],[12,14]]
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> results = new ArrayList<>();

        int idx = 0;

        while (idx < S.length()) {
            int start = idx, end = idx;
            while (idx < S.length() && S.charAt(start) == S.charAt(idx)) {
                end = idx;
                idx ++;
            }

            int size = end - start + 1;
            if (size >= 3) {
                List<Integer> result = new ArrayList<>();
                result.add(start);
                result.add(end);

                results.add(result);
            }
        }

        return results;
    }
}
