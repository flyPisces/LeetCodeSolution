package DecryptStringfromAlphabettoIntegerMapping;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 */
public class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < s.length();) {
            if (i < s.length() - 2 && s.charAt(i + 2) == '#') {
                int num = Integer.parseInt(s.substring(i, i + 2));

                char c = (char) ('a' + num - 1);
                sb.append(c);
                i = i + 3;
                continue;
            }

            int num = Integer.parseInt(s.substring(i, i + 1));
            char c = (char) ('a' + num - 1);
            sb.append(c);
            ++ i;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.freqAlphabets("10#11#12"));
    }
}
