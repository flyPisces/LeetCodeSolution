package LongestDuplicateSubstring;

import java.util.*;

/**
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

 Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)



 Example 1:

 Input: "banana"
 Output: "ana"
 Example 2:

 Input: "abcd"
 Output: ""
 */
public class Solution {
    public String longestDupSubstring(String S) {
        if (S == null) return null;

        int min = 0, max = S.length();
        String result = "";

        while (min < max) {
            int mid = min + (max - min) / 2;

            String temp = findDupStrWithLength(S, mid);

            if (temp.length() == mid) {
                min = mid + 1;
                result = temp.length() > result.length() ? temp : result;
            } else {
                max = mid;
            }
        }

        return result;
    }

    private String findDupStrWithLength(String S, int len) {
        if (len == 0 || len >= S.length()) return "";
        Map<Long, Set<String>> remainderStr = new HashMap<>();

        long MOD = 1 << 31 - 1;
        long base = 26;
        long hash = 0;

        for (int i = 0;i < len;++ i) {
            hash = (hash * base + S.charAt(i) - 'a') % MOD;
        }

        remainderStr.put(hash, new HashSet<>());
        remainderStr.get(hash).add(S.substring(0, len));

        long multiplier = 1;
        for (int i = 0;i < len - 1;++ i) {
            multiplier = (multiplier * base) % MOD;
        }

        int from = 0, to = len;

        while (to < S.length()) {
            hash = ((hash + MOD - multiplier * (S.charAt(from ++) - 'a') % MOD) * base + S.charAt(to ++) - 'a') % MOD;

            if (remainderStr.get(hash) == null) {
                remainderStr.put(hash, new HashSet<>());
                remainderStr.get(hash).add(S.substring(from, from + len));
            } else {
                if (remainderStr.get(hash).contains(S.substring(from, from + len))) {
                    return S.substring(from, from + len);
                } else {
                    remainderStr.get(hash).add(S.substring(from, from + len));
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.longestDupSubstring("banana"));
    }
}
