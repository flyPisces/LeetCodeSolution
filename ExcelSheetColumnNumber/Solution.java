package ExcelSheetColumnNumber;

/**
 *
 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 * Created by aoshen on 7/8/16.
 */
public class Solution {
    public int titleToNumber(String s) {
        if (null == s || s.length() == 0) return 0;

        int weight = 1;
        int result = 0;
        for (int i = s.length() - 1;i >= 0;-- i) {

            result += weight * (s.charAt(i) - 'A' + 1);
            weight = 26 * weight;
        }

        return result;
    }
}
