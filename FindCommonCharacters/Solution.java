package FindCommonCharacters;

import java.util.*;

/**
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

 You may return the answer in any order.



 Example 1:

 Input: ["bella","label","roller"]
 Output: ["e","l","l"]
 Example 2:

 Input: ["cool","lock","cook"]
 Output: ["c","o"]
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        int[] dp = new int[26];
        List<String> result = new ArrayList<>();

        for (char c : A[0].toCharArray()) {
            dp[c - 'a'] ++;
        }

        int[] temp = new int[26];
        for (int i = 1;i < A.length;++ i) {
            Arrays.fill(temp, 0);

            for (char c : A[i].toCharArray()) {
                temp[c - 'a'] ++;
            }

            for (int j = 0;j < 26;++ j) {
                dp[j] = Math.min(dp[j], temp[j]);
            }
        }

        for (int i = 0;i < 26;++ i) {
            for (int j = 0;j < dp[i];++ j) {
                result.add(String.valueOf((char)('a' + i)));
            }
        }

        return result;
    }
}
