package ExcelSheetColumnTitle;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 * Created by aoshen on 7/8/16.
 */
public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n --;
            sb.append((char) ('A' + n % 26));

            n = n / 26;
        }

        sb.reverse();

        return sb.toString();
    }
}
