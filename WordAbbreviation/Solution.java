package WordAbbreviation;

import java.util.*;

/**
 * Given an array of n distinct non-empty strings, you need to generate minimal possible abbreviations for every word following rules below.

 Begin with the first character and then the number of characters abbreviated, which followed by the last character.
 If there are any conflict, that is more than one words share the same abbreviation, a longer prefix is used instead of only the first character until making the map from word to abbreviation become unique. In other words, a final abbreviation cannot map to more than one original words.
 If the abbreviation doesn't make the word shorter, then keep it as original.
 Example:
 Input: ["like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"]
 Output: ["l2e","god","internal","me","i6t","interval","inte4n","f2e","intr4n"]
 Note:
 Both n and the length of each word will not exceed 400.
 The length of each word is greater than 1.
 The words consist of lowercase English letters only.
 The return answers should be in the same order as the original array.

 * Created by aoshen on 3/18/17.
 */
public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        int len = dict.size();
        String[] ans = new String[len];
        int[] prefix = new int[len];

        for (int i = 0;i < len;++ i) {
            prefix[i] = 1;
            ans[i] = makeAbbr(dict.get(i), prefix[i]);
        }

        for (int i = 0;i < len;++ i) {
            while (true) {
                Set<Integer> set = new HashSet<>();
                for (int j = i + 1;j < len;++ j) {
                    if (ans[i].equals(ans[j])) set.add(j);
                }

                if (set.isEmpty()) break;
                set.add(i);

                for (int k : set) {
                    ans[k] = makeAbbr(dict.get(k), ++ prefix[k]);
                }
            }
        }

        return Arrays.asList(ans);
    }

    private String makeAbbr(String s, int k) {
        if (k >= s.length() - 2) return s;

        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, k));
        sb.append(s.length() - 1 - k);
        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }
}
