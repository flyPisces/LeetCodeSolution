package RegularExpressionMatching;

/**
 * Created by aoshen on 9/17/16.
 */
public class SolutionDP {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] flags = new boolean[sLen + 1][pLen + 1];
        flags[0][0] = true;

        for (int i = 1;i <= pLen;++ i) {
            if (p.charAt(i - 1) == '*') flags[0][i] = flags[0][i - 2];
        }

        for (int i = 1;i <= sLen;++ i) {
            for (int j = 1;j <= pLen;++ j) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (sChar == pChar || pChar == '.') {
                    flags[i][j] = flags[i - 1][j - 1];
                } else if (pChar == '*') {
                    if (sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        flags[i][j] = flags[i][j - 2];
                    } else { // sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.'
                        flags[i][j] = flags[i][j - 2] | flags[i - 1][j];
                    }
                }
            }
        }

        return flags[sLen][pLen];
    }
}
