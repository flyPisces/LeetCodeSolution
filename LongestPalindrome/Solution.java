package LongestPalindrome;

import java.util.*;

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.

 * Created by aoshen on 10/2/16.
 */
public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(!set.add(c))
                set.remove(c);
        }
        int singleNumber = set.size() >= 2 ? set.size() - 1 : 0;
        return s.length() - singleNumber;
    }
}
