package PlusOne;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

    The digits are stored such that the most significant digit is at the head of the list.

 * Created by aoshen on 7/14/16.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = null;

        if (null == digits || digits.length == 0) {
            res = new int[1];
            res[0] = 1;

            return res;
        }

        int borrow = 1;
        for (int i = digits.length - 1;i >= 0;i --) {
            int sum = borrow + digits[i];

            digits[i] = sum % 10;
            borrow = sum / 10;
        }

        if (borrow != 0) {
            res = new int[digits.length + 1];
            res[0] = borrow;
            System.arraycopy(digits, 0, res, 1, digits.length);

            return res;
        }

        return digits;
    }
}
