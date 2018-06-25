package ShortEncodingofWords;

import java.util.*;

/**
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

 For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

 Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

 What is the length of the shortest reference string S possible that encodes the given words?

 Example:

 Input: words = ["time", "me", "bell"]
 Output: 10
 Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 */
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();

        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            for (int k = 1;k < word.length();++ k) {
                set.remove(word.substring(k));
            }
        }

        int answer = 0;
        for (String word : set) {
            answer += word.length() + 1;
        }

        return answer;
    }
}
