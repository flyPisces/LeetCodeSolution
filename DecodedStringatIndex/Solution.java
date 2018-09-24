package DecodedStringatIndex;

/**
 * An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

 If the character read is a letter, that letter is written onto the tape.
 If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.



 Example 1:

 Input: S = "leet2code3", K = 10
 Output: "o"
 Explanation:
 The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 The 10th letter in the string is "o".
 Example 2:

 Input: S = "ha22", K = 5
 Output: "h"
 Explanation:
 The decoded string is "hahahaha".  The 5th letter is "h".
 Example 3:

 Input: S = "a2345678999999999999999", K = 1
 Output: "a"
 Explanation:
 The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 */
public class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        for (int i = 0;i < N;++ i) {
            if (Character.isDigit(S.charAt(i))) {
                size *= S.charAt(i) - '0';
            } else {
                size ++;
            }
        }

        for (int i = N - 1;i >= 0;-- i) {
            char c = S.charAt(i);
            K %= size;
            if (0 == K && Character.isLetter(c)) {
                return Character.toString(c);
            }

            if (Character.isLetter(c)) {
                -- size;
            } else {
                size /= S.charAt(i) - '0';
            }
        }

        return null;
    }
}
