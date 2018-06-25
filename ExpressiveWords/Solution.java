package ExpressiveWords;

import java.util.*;

/**
 * Sometimes people repeat letters to represent extra feeling, such as
 * "hello" -> "heeellooo", "hi" -> "hiiii".  Here, we have groups,
 * of adjacent letters that are all the same character,
 * and adjacent characters to the group are different.
 * A group is extended if that group is length 3 or more,
 * so "e" and "o" would be extended in the first example,
 * and "i" would be extended in the second example.
 * As another example, the groups of "abbcccaaaa" would be "a", "bb", "ccc",
 * and "aaaa"; and "ccc" and "aaaa" are the extended groups of that string.

 For some given string S, a query word is stretchy if it can be made to be equal to S by extending some groups.
 Formally, we are allowed to repeatedly choose a group (as defined above) of characters c,
 and add some number of the same character c to it so that the length of the group is 3 or more.  Note that we cannot extend a group of size one like "h" to a group of size two like "hh" - all extensions must leave the group extended - ie., at least 3 characters long.

 Given a list of query words, return the number of words that are stretchy.

 Example:
 Input:
 S = "heeellooo"
 words = ["hello", "hi", "helo"]
 Output: 1
 Explanation:
 We can extend "e" and "o" in the word "hello" to get "heeellooo".
 We can't extend "helo" to get "heeellooo" because the group "ll" is not extended.
 */
class Solution {
    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;

        for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            boolean invalid = false;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2) {
                    invalid = true;
                    break;
                }
            }
            if (invalid) continue;
            ans++;
        }
        return ans;
    }
}

class RLE {
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || ca[i] != ca[i+1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }

        key = sb.toString();
    }
}