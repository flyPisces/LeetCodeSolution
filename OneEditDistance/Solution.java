package OneEditDistance;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * Created by aoshen on 6/27/16.
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            return isOneEditUpdate(s, t);
        }

        if (Math.abs(s.length() - t.length()) == 1) {
            String shorter = s.length() < t.length() ? s : t;
            String longer = s.length() > t.length() ? s : t;

            return isOneEditDel(shorter, longer);
        }

        return false;
    }

    private boolean isOneEditDel(String shorter, String longer) {
        for (int i = 0;i < shorter.length();++ i) {
            if (shorter.charAt(i) == longer.charAt(i)) {
                continue;
            } else {
                return shorter.substring(i).equals(longer.substring(i + 1));
            }
        }

        return true;
    }

    private boolean isOneEditUpdate(String s, String t) {
        for (int i = 0; i < s.length();++ i) {
            if (s.charAt(i) == t.charAt(i)) {
                continue;
            } else {
                return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }

        return false;
    }
}
