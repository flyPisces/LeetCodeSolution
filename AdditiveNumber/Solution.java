package AdditiveNumber;

import java.util.Locale;

/**
 * Additive number is a string whose digits can form additive sequence.

 A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

 For example:
 "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 1 + 99 = 100, 99 + 100 = 199
 Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

 Follow up:
 How would you handle overflow for very large input integers?

 * Created by aoshen on 8/13/16.
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0;i < num.length();++ i) {
            for (int j = i + 1;j < num.length() - i - 1;++ j) {
                String first = num.substring(0, i + 1);
                String second = num.substring(i + 1, j + 1);

                if (isValid(j + 1, num, first, second)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int start, String num, String first, String second) {
        if (start == num.length()) {
            return true;
        }

        long l1 = Long.parseLong(first);
        long l2 = Long.parseLong(second);

        if (!Long.toString(l1).equals(first) || !Long.toString(l2).equals(second)) {
            return false;
        }
        long sum = l1 + l2;
        String sumStr = Long.toString(sum);

        if (start + sumStr.length() > num.length()) {
            return false;
        }
        if (!Long.toString(sum).equals(sumStr)) {
            return false;
        }
        if (Long.parseLong(num.substring(start, start + sumStr.length())) != sum) {
            return false;
        }

        return isValid(start + sumStr.length(), num, second, sumStr);
    }
}
