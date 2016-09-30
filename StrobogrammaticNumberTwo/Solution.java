package StrobogrammaticNumberTwo;

import java.util.*;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,
 Given n = 2, return ["11","69","88","96"].

 * Created by aoshen on 7/20/16.
 */
public class Solution {

    List<String> results = new ArrayList<>();
    char[] table = {'0', '1', '8', '6', '9'};

    public List<String> findStrobogrammatic(int n) {
        helper(n, "");

        return results;
    }

    private void helper(int n, String tmp) {
        if (tmp.length() == n) {
            results.add(tmp);
            return;
        }

        boolean last = (n - tmp.length() == 1);
        for (int i = 0;i < table.length;++ i) {
            if ( (n != 1 && table[i] == '0' && tmp.length() == 0) || (last == true && (table[i] == '6' ||
                table[i] == '9'))) {
                continue;
            }

            StringBuilder sb = new StringBuilder(tmp);
            appendString(sb, table[i], last);
            helper(n, sb.toString());
        }
    }

    private void appendString(StringBuilder sb, char c, boolean last) {
        if (c == '6') {
            sb.insert(sb.length() / 2, "69");
        } else if (c == '9') {
            sb.insert(sb.length() / 2, "96");
        } else {
            sb.insert(sb.length() / 2, last == true ? c : "" + c + c);
        }
    }
}
