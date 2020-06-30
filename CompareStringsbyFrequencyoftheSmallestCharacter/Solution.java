package CompareStringsbyFrequencyoftheSmallestCharacter;

import java.util.Arrays;

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 *
 *
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 */

public class Solution {
    int[] dp = new int[26];

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qArr = new int[queries.length], wArr = new int[words.length];

        int idx = 0;
        for (String query : queries) {
            qArr[idx ++] = fVal(query);
        }

        idx = 0;
        for (String word : words) {
            wArr[idx ++] = fVal(word);
        }

        Arrays.sort(wArr);

        int[] ans = new int[queries.length];
        for (int i = 0;i < ans.length;++ i) {
            ans[i] = getAnswer(qArr[i], wArr);
        }

        return ans;

    }

    private int getAnswer(int num, int[] wArr) {
        int start = 0, end = wArr.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (wArr[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return wArr.length - start;
    }

    private int fVal(String str) {
        Arrays.fill(dp,0);

        for (char c : str.toCharArray()) {
            dp[c - 'a'] ++;
        }

        for (int i = 0;i < 26;++ i) {
            if (dp[i] > 0) return dp[i];
        }

        return 0;
    }
}
