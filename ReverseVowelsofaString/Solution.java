package ReverseVowelsofaString;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".
 *
 * Created by aoshen on 5/20/16.
 */
public class Solution {

    Set<Character> vowelSet = new HashSet<>();

    public String reverseVowels(String s) {

        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            while (start < end && !vowelSet.contains(arr[start])) {
                start ++;
            }

            while (start < end && !vowelSet.contains(arr[end])) {
                end --;
            }

            if (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start ++;
                end --;
            }
        }

        return new String(arr);
    }
}
