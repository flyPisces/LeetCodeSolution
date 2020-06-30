package BasicCalculatorTwo;

/**
 * Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.

 * Created by aoshen on 8/11/16.
 */
public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int prev = 0;
        int result = 0;
        int sign = 1;
        int md = -1;

        s = s.trim();
        for (int i = 0;i < s.length();++ i) {
            if (Character.isDigit(s.charAt(i))) {
                int num = Integer.parseInt(String.valueOf(s.charAt(i)));

                while (++ i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + Integer.parseInt(String.valueOf(s.charAt(i)));
                }

                -- i;

                if (md == 0) {
                    prev = prev * num;
                    md = -1;
                } else if (md == 1) {
                    prev = prev / num;
                    md = -1;
                } else {
                    prev = num;
                }
            } else if (s.charAt(i) == '+') {
                result = result + sign * prev;
                sign = 1;
            } else if (s.charAt(i) == '-') {
                result = result + sign * prev;
                sign = -1;
            } else if (s.charAt(i) == '*') {
                md = 0;
            } else {
                md = 1;
            }
        }

        result = result + sign * prev;
        return result;

        /**
         *     int len;
         *     if(s==null || (len = s.length())==0) return 0;
         *     Stack<Integer> stack = new Stack<Integer>();
         *     int num = 0;
         *     char sign = '+';
         *     for(int i=0;i<len;i++){
         *         if(Character.isDigit(s.charAt(i))){
         *             num = num*10+s.charAt(i)-'0';
         *         }
         *         if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
         *             if(sign=='-'){
         *                 stack.push(-num);
         *             }
         *             if(sign=='+'){
         *                 stack.push(num);
         *             }
         *             if(sign=='*'){
         *                 stack.push(stack.pop()*num);
         *             }
         *             if(sign=='/'){
         *                 stack.push(stack.pop()/num);
         *             }
         *             sign = s.charAt(i);
         *             num = 0;
         *         }
         *     }
         *
         *     int re = 0;
         *     for(int i:stack){
         *         re += i;
         *     }
         *     return re;
         */
    }
}
