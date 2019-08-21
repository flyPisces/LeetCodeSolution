package OccurrencesAfterBigram;

import java.util.ArrayList;
import java.util.List;

/**
 * Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

 For each such occurrence, add "third" to the answer, and return the answer.



 Example 1:

 Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 Output: ["girl","student"]
 Example 2:

 Input: text = "we will we will rock you", first = "we", second = "will"
 Output: ["we","rock"]

 */
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] splits = text.split(" ");

        List<String> list = new ArrayList<>();
        for (int i = 0;i < splits.length - 2;++ i) {
            if (splits[i].equals(first) && splits[i + 1].equals(second)) {
                list.add(splits[i + 2]);
            }
        }

        String[] results = new String[list.size()];
        for (int i = 0;i < results.length;++ i) {
            results[i] = list.get(i);
        }

        return results;
    }
}
