package SwapAdjacentinLRString;

/**
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
 * a move consists of either replacing one occurrence of "XL" with "LX",
 * or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
 *
 * return True if and only if there exists a sequence of moves to transform one string to the other.

 Example:

 Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 Output: True
 Explanation:
 We can transform start to end following these steps:
 RXXLRXRXL ->
 XRXLRXRXL ->
 XRLXRXRXL ->
 XRLXXRRXL ->
 XRLXXRRLX
 */
public class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replaceAll("X","")
                .equals(end.replaceAll("X",""))) {
            return false;
        }

        int idx = 0;
        for (int i = 0;i < start.length();++ i) {
            if (start.charAt(i) != 'L') continue;
            while (idx < end.length() && end.charAt(idx) != 'L') idx ++;
            if (i < idx ++) return false;
        }

        idx = 0;
        for (int i = 0;i < start.length();++ i) {
            if (start.charAt(i) != 'R') continue;
            while (idx < end.length() && end.charAt(idx) != 'R') idx ++;
            if (i > idx ++) return false;
        }

        return true;
    }
}
