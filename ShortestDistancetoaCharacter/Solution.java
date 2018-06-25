package ShortestDistancetoaCharacter;

/**
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

 Example 1:

 Input: S = "loveleetcode", C = 'e'
 Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] results = new int[S.length()];

        int prev = Integer.MIN_VALUE / 2;
        int N = S.length();

        for (int i = 0;i < N;++ i) {
            if (S.charAt(i) == C) {
                prev = i;
            }

            results[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1;i >= 0;-- i) {
            if (S.charAt(i) == C) {
                prev = i;
            }

            results[i] = Math.min(results[i], prev - i);
        }

        return results;
    }
}
