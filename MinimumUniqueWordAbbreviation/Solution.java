package MinimumUniqueWordAbbreviation;

/**
 * A string such as "word" contains the following abbreviations:

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 Given a target string and a set of strings in a dictionary, f
 ind an abbreviation of this target string with the smallest possible length such that
 it does not conflict with abbreviations of the strings in the dictionary.

 Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

 Note:
 In the case of multiple answers as shown in the second example below, you may return any one of them.
 Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
 Examples:
 "apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

 "apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").

 * Created by aoshen on 10/28/16.
 */
public class Solution {
    String ret = "";
    public String minAbbreviation(String target, String[] dictionary) {
        ret = target;
        allAbbrs("", 0, target, 0, dictionary);
        return ret;
    }

    public void allAbbrs(String cur, int count, String word, int index, String[] dictionary) {
        // pruning
        if (cur.length() >= ret.length()) {
            return;
        }
        if (index == word.length()) {
            if (count != 0) {
                cur = cur + count;
            }
            if (checkDictionary(cur, dictionary)) {
                if (cur.length() < ret.length()) {
                    ret = cur;
                }
            }
            return;
        }

        allAbbrs(cur, count + 1, word, index + 1, dictionary);
        if (count == 0) {
            cur = cur + word.charAt(index);
            allAbbrs(cur, 0, word, index + 1, dictionary);
        } else {
            cur = cur + count + word.charAt(index);
            allAbbrs(cur, 0, word, index + 1, dictionary);
        }
    }

    public boolean checkDictionary(String abbr, String[] dictionary) {
        int invalid = 0;
        for (String word : dictionary) {
            if (checkWord(word, abbr)) {
                return false;
            } else {
                invalid++;
            }
        }
        return invalid == dictionary.length;
    }

    public boolean checkWord(String word, String abbr) {
        int i = 0, j = 0;
        int m = abbr.length(), n = word.length();
        char[] words = word.toCharArray();
        char[] abbrs = abbr.toCharArray();
        int num = 0;
        while (i < n && j < m) {
            if (Character.isLetter(abbrs[j])) {
                i = i + num;
                if (i >= n || abbrs[j] != words[i]) {
                    return false;
                }
                i++;
                num = 0;
            } else if (Character.isDigit(abbrs[j])) {
                if (abbrs[j] == '0' && num == 0) {
                    return false;
                }
                num = num * 10 + abbrs[j] - '0';
            }
            j++;
        }
        if (num != 0) {
            i = i + num;
        }
        return i == n && j == m;
    }
}
