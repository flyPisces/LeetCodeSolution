package ReplacetheSubstringforBalancedString;

/**
 *
 You are given a string containing only 4 kinds of characters 'Q', 'W', 'E' and 'R'.

 A string is said to be balanced if each of its characters appears n/4 times where n is the length of the string.

 Return the minimum length of the substring that can be replaced with any other string of the same length to make the original string s balanced.

 Return 0 if the string is already balanced.



 Example 1:

 Input: s = "QWER"
 Output: 0
 Explanation: s is already balanced.
 Example 2:

 Input: s = "QQWE"
 Output: 1
 Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
 Example 3:

 Input: s = "QQQW"
 Output: 2
 Explanation: We can replace the first "QQ" to "ER".
 Example 4:

 Input: s = "QQQQ"
 Output: 3
 Explanation: We can replace the last 3 'Q' to make s = "QWER".
 */
public class Solution {
    public int balancedString(String s) {
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c] ++;
        }

        int N = s.length(), target = N / 4;

        int left = 0, right = 0, result = N;

        while (right <= N) {
            if (count['Q'] > target || count['W'] > target || count['E'] > target || count['R'] > target) {
                if (right >= N) break;
                char rightChar = s.charAt(right);
                count[rightChar] --;
                right ++;
                continue;
            }

            result = Math.min(result, right - left);
            if (0 == result) break;

            char leftChar = s.charAt(left);
            count[leftChar] ++;
            left ++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.balancedString("WQWRQQQW"));
    }

    /** https://leetcode.com/problems/replace-the-substring-for-balanced-string/discuss/408978/JavaC%2B%2BPython-Sliding-Window
     *
     *     public int balancedString(String s) {
     *         int[] count = new int[128];
     *         int n = s.length(), res = n, i = 0, k = n / 4;
     *         for (int j = 0; j < n; ++j) {
     *             ++count[s.charAt(j)];
     *         }
     *         for (int j = 0; j < n; ++j) {
     *             --count[s.charAt(j)];
     *             while (i < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k) {
     *                 res = Math.min(res, j - i + 1);
     *                 ++count[s.charAt(i++)];
     *             }
     *         }
     *         return res;
     *     }
     */
}
