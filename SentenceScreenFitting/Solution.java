package SentenceScreenFitting;

/**
 * Given a rows x cols screen and a sentence represented by a list of words, find how many times the given sentence can be fitted on the screen.

 Note:

 A word cannot be split into two lines.
 The order of words in the sentence must remain unchanged.
 Two consecutive words in a line must be separated by a single space.
 Total words in the sentence won't exceed 100.
 Length of each word won't exceed 10.
 1 ≤ rows, cols ≤ 20,000.
 Example 1:

 Input:
 rows = 2, cols = 8, sentence = ["hello", "world"]

 Output:
 1

 Explanation:
 hello---
 world---

 The character '-' signifies an empty space on the screen.
 Example 2:

 Input:
 rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

 Output:
 2

 Explanation:
 a-bcd-
 e-a---
 bcd-e-

 The character '-' signifies an empty space on the screen.
 Example 3:

 Input:
 rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

 Output:
 1

 Explanation:
 I-had
 apple
 pie-I
 had--

 The character '-' signifies an empty space on the screen.

 * Created by aoshen on 10/10/16.
 */
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, len = s.length();

        for (int i = 0;i < rows; ++ i) {
            start += cols;

            if (s.charAt(start % len) == ' ') {
                start ++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start --;
                }
            }
        }

        return start / s.length();

    }
}