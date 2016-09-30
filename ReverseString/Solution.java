package ReverseString;

import java.util.*;

/**
 * Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".

 * Created by aoshen on 4/23/16.
 */
public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1;i >= 0;-- i) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
