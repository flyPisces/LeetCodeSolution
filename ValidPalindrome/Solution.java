package ValidPalindrome;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    For example,
    "A man, a plan, a canal: Panama" is a palindrome.
    "race a car" is not a palindrome.
 * 
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;       
        }
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start <  end) {
            if (!isAlphanumeric(s.charAt(start))) {
                start ++;
                continue;
            }
            
            if (!isAlphanumeric(s.charAt(end))) {
                end --;
                continue;
            }
            
 
            if (!isMatch(s.charAt(start), s.charAt(end))) {
                return false;
            }
            
            start ++;
            end --;
        }
        
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        
        return false;
    }
    
    public boolean isMatch(char c1, char c2) {
        if(c1>='A' && c1<='Z')  
            c1 = (char)(c1-'A'+'a');  
        if(c2>='A' && c2<='Z')  
            c2 = (char)(c2-'A'+'a');  
            
        return c1==c2;  
    }
}
