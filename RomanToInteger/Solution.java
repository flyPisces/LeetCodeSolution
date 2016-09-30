package RomanToInteger;

/**
 * Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.

 * Created by aoshen on 4/22/16.
 */
public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == 'I'){
                if(res >= 5)
                    res += -1;
                else
                    res += 1;
            }else if(c == 'V'){
                res += 5;
            }else if(c == 'X'){
                if(res >= 50)
                    res += -10;
                else
                    res += 10;
            }else if(c == 'L'){
                res += 50;
            }else if(c == 'C'){
                if(res >= 500)
                    res += -100;
                else
                    res += 100;
            }else if(c == 'D'){
                res += 500;
            }else if(c == 'M'){
                res += 1000;
            }
        }
        return res;
    }
}
