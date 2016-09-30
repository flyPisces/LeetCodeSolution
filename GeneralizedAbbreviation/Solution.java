package GeneralizedAbbreviation;

import java.util.*;

/**
 * Write a function to generate the generalized abbreviations of a word.

 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 * Created by aoshen on 7/20/16.
 */
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> results = new ArrayList<>();

        if (word == null) {
            return results;
        }

        dfs(results, 0, 0, new StringBuilder(), word);

        return results;
    }

    private void dfs(List<String> results, int count, int pos, StringBuilder sb, String word) {
        int originalSize = sb.length();

        if (pos == word.length()) {
            if (count > 0) {
                sb.append(count);
            }

            results.add(sb.toString());
        } else {
            dfs(results, count + 1, pos + 1, sb, word);

            if (count > 0) sb.append(count);
            sb.append(word.charAt(pos));
            dfs(results, 0, pos + 1, sb, word);
        }

        sb.setLength(originalSize);
    }
}
