package PalindromePartitioning;

import java.util.*;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    For example, given s = "aab",
    Return

    [
    ["aa","b"],
    ["a","a","b"]
    ]

 * Created by aoshen on 4/17/16.
 */
public class  Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            return results;
        }

        dfs(0, s, result, results);

        return results;
    }

    public void dfs(int index, String s, List<String> result, List<List<String>> results) {
        if (index == s.length()) {
            results.add(new ArrayList<String>(result));
            return;
        }

        for (int i = index;i < s.length();++ i) {
            if (isPanlindrome(s, index, i)) {
                result.add(s.substring(index, i + 1));
                dfs(i + 1, s, result, results);
                result.remove(result.size() - 1);
            }
        }
    }

    public boolean isPanlindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start ++;
            end --;
        }

        return true;
    }
}
