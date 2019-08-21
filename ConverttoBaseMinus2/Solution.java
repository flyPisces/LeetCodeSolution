package ConverttoBaseMinus2;

/**
 * Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).

 The returned string must have no leading zeroes, unless the string is "0".



 Example 1:

 Input: 2
 Output: "110"
 Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 Example 2:

 Input: 3
 Output: "111"
 Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 Example 3:

 Input: 4
 Output: "100"
 Explantion: (-2) ^ 2 = 4
 */
public class Solution {
    public String baseNeg2(int N) {
        String res = "";
        while (N != 0) {
            res = Integer.toString(N & 1) + res;
            N = -(N >> 1);
        }
        return res == ""  ? "0" : res;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.baseNeg2(2));
    }

    /**
     *
     *     def baseNeg2(self, N: int) -> str:
     neg = [1 << i for i in range(1, 33, 2)]
     for mask in neg:
     if N & mask: N += mask*2
     return bin(N)[2:]
     */
}
