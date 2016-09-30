package ReverseWordsinaStringTwo;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

    The input string does not contain leading or trailing spaces and the words are always separated by a single space.

    For example,
    Given s = "the sky is blue",
    return "blue is sky the".

    Could you do it in-place without allocating extra space?

 * Created by aoshen on 7/5/16.
 */
public class Solution {
    public void reverseWords(char[] s) {
        if  (s == null || s.length == 0) return;

        reverseWord(s, 0, s.length - 1);

        int startWord = 0, endWord = 0;
        for (int i = 0;i != s.length;++ i) {
            if (s[i] == ' ') {
                reverseWord(s, startWord, endWord - 1);

                startWord = i + 1;
            }

            endWord ++;
        }

        reverseWord(s, startWord, s.length - 1);
    }

    public void reverseWord(char[] s, int startWord, int endWord) {
        while (startWord < endWord) {
            char temp = s[startWord];
            s[startWord] = s[endWord];
            s[endWord] = temp;

            startWord ++;
            endWord --;
        }
    }
}
