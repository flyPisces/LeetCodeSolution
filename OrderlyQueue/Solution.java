package OrderlyQueue;

import java.util.Arrays;

/**
 *
 A string S of lowercase letters is given.  Then, we may make any number of moves.

 In each move, we choose one of the first K letters (starting from the left),
 remove it, and place it at the end of the string.

 Return the lexicographically smallest string we could have after any number of moves.



 Example 1:

 Input: S = "cba", K = 1
 Output: "acb"
 Explanation:
 In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
 In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
 Example 2:

 Input: S = "baaca", K = 3
 Output: "aaabc"
 Explanation:
 In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
 In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
 */
public class Solution {
    public String orderlyQueue(String S, int K) {
        if (1 == K) {
            String result = S;

            for (int i = 0;i < S.length();++ i) {
                String T = S.substring(i) + S.substring(0, i);
                if (T.compareTo(result) < 0) result = T;
            }

            return result;
        } else {
            char[] arr = S.toCharArray();
            Arrays.sort(arr);

            return new String(arr);
        }
    }
}
