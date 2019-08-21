package CamelcaseMatching;

import java.util.*;

/**
 * A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

 Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.



 Example 1:

 Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 Output: [true,false,true,true,false]
 Explanation:
 "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 Example 2:

 Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 Output: [true,false,true,false,false]
 Explanation:
 "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 Example 3:

 Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 Output: [false,true,false,false,false]
 Explanation:
 "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 */
public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> results = new ArrayList<>();

        char[] patternArr = pattern.toCharArray();

        for (String query : queries) {
            results.add(isMatch(query.toCharArray(), patternArr));
        }

        return results;
    }

    private boolean isMatch(char[] queryArr, char[] patternArr) {
        int j = 0;

        for (int i = 0;i < queryArr.length;++ i) {
            if (j < patternArr.length && queryArr[i] == patternArr[j]) {
                ++ j;
            } else if (queryArr[i] >= 'A' && queryArr[i] <= 'Z') {
                return false;
            }
        }

        return j == patternArr.length;
    }
}
