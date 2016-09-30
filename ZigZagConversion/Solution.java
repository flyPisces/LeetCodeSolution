package ZigZagConversion;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * @author alshen
 *
 */


public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return "";
        }
        
        if (s == null || s.length() == 0 || numRows == 1) {
            return s;
        }
        
        int step = 2 * numRows - 2;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0;i != numRows;++ i) {
            if (i != 0 && i != numRows - 1) {
                for (int vertical = i, diagonal = 2 * numRows - 2 - i;vertical < len || diagonal < len;
                        vertical = vertical + step, diagonal = diagonal + step) {
                    if (vertical < len) {
                        sb.append(s.charAt(vertical));
                    } else {
                        break;
                    }
                    
                    if (diagonal < len) {
                        sb.append(s.charAt(diagonal));
                    } else {
                        break;
                    }
                }
            } else {
                for (int j = i;j < len;j = j + step) {
                    sb.append(s.charAt(j));
                }
            }
        }
        
        return sb.toString();         
    }
}
