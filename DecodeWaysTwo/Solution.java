package DecodeWaysTwo;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

 Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: "*"
 Output: 9
 Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 Example 2:
 Input: "1*"
 Output: 9 + 9 = 18

 * Created by aoshen on 7/21/17.
 */
public class Solution {
    public int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int)res[0];

        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return  (int)res[1];
    }

    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }

    private int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            }
        }
        return 0;
    }
}