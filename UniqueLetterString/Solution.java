package UniqueLetterString;

import java.util.Arrays;

/**
 *
 A character is unique in string S if it occurs exactly once in it.

 For example, in string S = "LETTER", the only unique characters are "L" and "R".

 Let's define UNIQ(S) as the number of unique characters in string S.

 For example, UNIQ("LETTER") =  2.

 Given a string S with only uppercases, calculate the sum of UNIQ(substring) over all non-empty substrings of S.

 If there are two or more equal substrings at different positions in S, we consider them different.

 Since the answer can be very large, retrun the answer modulo 10 ^ 9 + 7.
 */
public class Solution {
    public int uniqueLetterString(String S) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; ++i) Arrays.fill(index[i], -1);
        int res = 0, N = S.length(), mod = (int)Math.pow(10, 9) + 7;
        for (int i = 0; i < N; ++i) {
            int c = S.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[] {index[c][1], i};
        }
        for (int c = 0; c < 26; ++c)
            res = (res + (N - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }
}
