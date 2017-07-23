package ValidWordAbbreviation;

/**
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

 A string such as "word" contains only the following valid abbreviations:

 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 Notice that only the above abbreviations are valid abbreviations of the string "word".
 Any other string is not a valid abbreviation of "word".

 Note:
 Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

 Example 1:
 Given s = "internationalization", abbr = "i12iz4n":

 Return true.
 Example 2:
 Given s = "apple", abbr = "a2e":

 Return false.

 * Created by aoshen on 10/3/16.
 */
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null && abbr == null) return true;
        if (word == null || abbr == null) return false;

        int len1 = word.length();
        int len2 = abbr.length();
        int i = 0, j = 0;

        while (i < len1 && j < len2) {
            int num = 0;
            while (j < len2 && Character.isDigit(abbr.charAt(j))) {
                int digit = abbr.charAt(j ++) - '0';

                num = 10* num + digit;
                if (0 == num) return false;
            }
            i += num;
            if (i < len1 && j < len2 && word.charAt(i) != abbr.charAt(j)) return false;
            if (i == len1 && j == len2) return true;
            ++ i;
            ++ j;
        }

        return (i == len1 && j == len2);
    }
}
