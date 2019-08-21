package LongestChunkedPalindromeDecomposition;

/**
 * Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:

 Each a_i is a non-empty string;
 Their concatenation a_1 + a_2 + ... + a_k is equal to text;
 For all 1 <= i <= k,  a_i = a_{k+1 - i}.


 Example 1:

 Input: text = "ghiabcdefhelloadamhelloabcdefghi"
 Output: 7
 Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
 Example 2:

 Input: text = "merchant"
 Output: 1
 Explanation: We can split the string on "(merchant)".
 Example 3:

 Input: text = "antaprezatepzapreanta"
 Output: 11
 Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
 Example 4:

 Input: text = "aaa"
 Output: 3
 Explanation: We can split the string on "(a)(a)(a)".
 */
public class Solution {
    public int longestDecomposition(String text) {
        int res = 0, n = text.length();

        String lb = "", rb = "";

        for (int i = 0;i < n;++ i) {
            lb = lb + text.charAt(i);
            rb = text.charAt(n - 1 - i) + rb;

            if (lb.equals(rb)) {
                res ++;
                lb = "";
                rb = "";
            }
        }

        return res;
    }
}
