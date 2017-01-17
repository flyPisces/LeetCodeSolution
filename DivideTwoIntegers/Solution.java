package DivideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.

 * Created by aoshen on 11/3/16.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0||dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        int res=0,sign=(dividend<0)^(divisor<0)?-1:1;
        long dvd=Math.abs((long)dividend),dvs=Math.abs((long)divisor);
        while(dvd>=dvs){
            long mul=1,temp=dvs;
            while(dvd>=temp<<1){temp<<=1;mul<<=1;}
            dvd-=temp;res+=mul;
        }
        return res*sign;
    }
}
