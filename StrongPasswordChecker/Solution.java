package StrongPasswordChecker;

/**
 * A password is considered strong if below conditions are all met:

 It has at least 6 characters and at most 20 characters.
 It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
 It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..."
 is strong, assuming other conditions are met).
 Write a function strongPasswordChecker(s), that takes a string s as input,
 and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.

 Insertion, deletion or replace of any one character are all considered as one change.

 * Created by aoshen on 10/21/16.
 */
public class Solution {
    public int strongPasswordChecker(String s) {

        char [] str = s.toCharArray();
        boolean isUpper = false, isLower = false, isDigit = false;
        int missinType = 3;
        for(char c: str)
        {
            if(!isUpper && Character.isUpperCase(c)) { isUpper = true; missinType-=1; } //uppercase
            if(!isLower && Character.isLowerCase(c)) { isLower = true; missinType-=1; } //lowercase
            if(!isDigit && Character.isDigit(c)) { isDigit = true; missinType-=1; } //atleast one number

        }

        int totalChangeCnt = 0, OneChangeCnt =0, TwoChangeCnt =0, pos=2;
        while(pos < s.length())
        {
            if(str[pos]==str[pos-1] && str[pos-1]==str[pos-2] && str[pos-2]==str[pos])
            {
                int length = 2;
                while(pos < s.length() && str[pos]==str[pos-1])
                {
                    length += 1; pos +=1;
                }
                totalChangeCnt += length/3;
                if(length%3==0) OneChangeCnt += 1;
                else if(length%3==1) TwoChangeCnt += 1;

            }
            else
            {
                pos=pos+1;
            }
        }

        if(s.length()<6)
            return Math.max(missinType, 6-s.length());
        else if(s.length() <=20)
            return Math.max(missinType,totalChangeCnt );
        else
        {
            int deleteCount = s.length()-20;
            totalChangeCnt -= Math.min(deleteCount,OneChangeCnt*1)/1;
            totalChangeCnt -= Math.min(Math.max(deleteCount - OneChangeCnt, 0), TwoChangeCnt * 2) / 2;
            totalChangeCnt -= Math.max(deleteCount - OneChangeCnt - 2 * TwoChangeCnt, 0) / 3;


            return deleteCount + Math.max(missinType, totalChangeCnt);

        }
    }
}
