package StrobogrammaticNumberIII;

import java.util.*;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

 For example,
 Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

 * Created by aoshen on 8/14/16.
 */
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        List<String> results = new ArrayList<>();

        for (int i = low.length();i <= high.length();++ i) {
            results.addAll(helper(i, i));
        }

        for (String str : results) {
            if ((str.length() == low.length() && str.compareTo(low) < 0) || (str.length() == high.length() &&
                str.compareTo(high) > 0)) {
                continue;
            }

            count ++;
        }

        return count;
    }

    private List<String> helper(int m, int n) {
        List<String> results = new ArrayList<>();

        if (m == 0) {
            results.add("");
            return results;
        } else if (m == 1) {
            results.add("0");
            results.add("1");
            results.add("8");

            return results;
        }

        List<String> temp = helper(m - 2, n);
        for (String subStr : temp) {
            if (m != n) {
                results.add("0" + subStr + "0");
            }

            results.add("1" + subStr + "1");
            results.add("8" + subStr + "8");
            results.add("6" + subStr + "9");
            results.add("9" + subStr + "6");
        }

        return results;
    }
}
