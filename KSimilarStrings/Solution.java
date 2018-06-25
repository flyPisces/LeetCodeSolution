package KSimilarStrings;

import java.util.*;

/**
 * Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

 Given two anagrams A and B, return the smallest K for which A and B are K-similar.

 Example 1:

 Input: A = "ab", B = "ba"
 Output: 1
 Example 2:

 Input: A = "abc", B = "bca"
 Output: 2
 Example 3:

 Input: A = "abac", B = "baca"
 Output: 2
 Example 4:

 Input: A = "aabc", B = "abca"
 Output: 2

 */
public class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        Queue<String> list = new LinkedList<>();

        set.add(A);
        list.add(A);
        int result = 0;

        while (!list.isEmpty()) {
            result ++;
            int size = list.size();

            for (int k = 0;k < size;++ k) {
                String str = list.poll();

                int i = 0;
                while (str.charAt(i) == B.charAt(i)) ++ i;
                for (int j = i + 1;j < B.length();++ j) {
                    if (str.charAt(j) == B.charAt(j) || str.charAt(j) != B.charAt(i)) continue;
                    String temp = swap(str, i, j);
                    if (temp.equals(B)) return result;
                    if (set.add(temp)) list.add(temp);
                }
            }
        }

        return result;
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
}
