package MultiplyString;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note:
 The numbers can be arbitrarily large and are non-negative.
 Converting the input string to integer is NOT allowed.
 You should NOT use internal library such as BigInteger.
 *
 * Created by aoshen on 5/16/16.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.isEmpty() || num2 == null || num2.isEmpty()) {
            return "";
        }

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] res = new int[num1.length() + num2.length()];

        for (int i = 0;i != num1.length();++ i) {
            int d1 = num1.charAt(i) - '0';
            for (int j = 0;j != num2.length();++ j) {
                int d2 = num2.charAt(j) - '0';

                res[i + j] += d1 * d2;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0;i != res.length;++ i) {
            int digit = res[i] % 10;
            int carried = res[i] / 10;

            sb.insert(0, digit);
            if (i < res.length - 1) {
                res[i + 1] += carried;
            }
        }

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
