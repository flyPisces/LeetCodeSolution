package MonotoneIncreasingDigits;

/**
 * Given a non-negative integer N,
 * find the largest number that is less than or equal to N with monotone increasing digits.

 (Recall that an integer has monotone increasing digits
 if and only if each pair of adjacent digits x and y satisfy x <= y.)

 Example 1:
 Input: N = 10
 Output: 9
 Example 2:
 Input: N = 1234
 Output: 1234
 Example 3:
 Input: N = 332
 Output: 299
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N <= 9) return N;
        char[] arr = String.valueOf(N).toCharArray();

        int mark = arr.length;
        for (int i = arr.length - 1;i > 0;-- i) {
            if (arr[i] < arr[i - 1]) {
                mark = i - 1;
                arr[i - 1] --;
            }
        }

        for (int j = mark + 1;j < arr.length;++ j) {
            arr[j] = '9';
        }

        return Integer.parseInt(new String(arr));
    }
}
