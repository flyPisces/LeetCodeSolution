package GroupsofSpecialEquivalentStrings;

import java.util.*;

/**
 * You are given an array A of strings.

 Two strings S and T are special-equivalent if after any number of moves, S == T.

 A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].

 Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.

 Return the number of groups of special-equivalent strings from A.



 Example 1:

 Input: ["a","b","c","a","c","c"]
 Output: 3
 Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 Example 2:

 Input: ["aa","bb","ab","ba"]
 Output: 4
 Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 Example 3:

 Input: ["abc","acb","bac","bca","cab","cba"]
 Output: 3
 Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 Example 4:

 Input: ["abcd","cdab","adcb","cbad"]
 Output: 1
 Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 */
public class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();

        for (String S : A) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0;i < S.length();i = i + 2) {
                sb.append(S.charAt(i));
            }

            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String oddStr = new String(arr);

            sb.setLength(0);
            for (int i = 1;i < S.length();i = i + 2) {
                sb.append(S.charAt(i));
            }
            arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String evenStr = new String(arr);

            set.add(oddStr + evenStr);
        }

        return set.size();
    }
}
