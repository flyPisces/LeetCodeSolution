package CrackingtheSafe;

import java.util.*;

/**
 * There is a box protected by a password. The password is n digits,
 * where each letter can be one of the first k digits 0, 1, ..., k-1.

 You can keep inputting the password, the password will automatically be matched against the last n digits entered.

 For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.

 Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.

 Example 1:
 Input: n = 1, k = 2
 Output: "01"
 Note: "10" will be accepted too.
 Example 2:
 Input: n = 2, k = 2
 Output: "00110"
 Note: "01100", "10011", "11001" will be accepted too.
 */
public class Solution {
    Set<String> seen = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public String crackSafe(int n, int k) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0;i < n - 1;++ i) {
            temp.append(0);
        }
        String node = temp.toString();

        dfs(node, k);
        sb.append(node);

        return sb.toString();
    }

    private void dfs(String node, int k) {
        for (int i = 0;i < k;++ i) {
            String newStr = node + i;
            if (!seen.contains(newStr)) {
                seen.add(newStr);
                dfs(newStr.substring(1), k);
                sb.append(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.crackSafe(2,2));
    }
}
