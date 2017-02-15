package Base7;

/**
 * Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].

 * Created by aoshen on 2/14/17.
 */
public class Solution {
    public String convertToBase7(int num) {
        if (0 == num) return "0";

        boolean negative = false;
        if (num < 0) negative = true;

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(Math.abs(num % 7));
            num /= 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
