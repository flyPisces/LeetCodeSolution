package RemoveKDigits;

import java.util.*;

/**
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 * Created by aoshen on 9/23/16.
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < num.length();++ i) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k --;
            }

            if (i < num.length() - 1 && num.charAt(i) > num.charAt(i + 1) && k > 0) {
                k --;
            } else {
                stack.push(num.charAt(i));
            }
        }

        for (int i = 0;i < k;++ i) stack.pop();
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        int index = 0;
        while(index < ans.length() && ans.charAt(index) == '0') index++;
        return index == ans.length()? "0" : ans.substring(index);
    }
}
