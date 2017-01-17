package AddStrings;

/**
 *
 Total Accepted: 3990
 Total Submissions: 9098
 Difficulty: Easy
 Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.

 * Created by aoshen on 10/12/16.
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 || len2 >= 0) {
            int n1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int n2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;

            int sum = n1 + n2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
            len1 --;
            len2 --;
        }

        if (carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
