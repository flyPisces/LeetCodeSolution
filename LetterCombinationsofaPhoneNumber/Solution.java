package LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

    A  mapping of digit to letters (just like on the telephone buttons) is given below.

    Input:Digit string "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 *  Created by aoshen on 4/23/16.
 */
public class Solution {

    public List<String> letterCombinations(String digits) {
        String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList<String>();

        if (digits == null || digits.length() == 0) {
            return results;
        }

        StringBuilder sb = new StringBuilder();
        combination_helper(ss, digits, 0, sb, results);
        return results;
    }

    public void combination_helper(String[] ss, String digits, int index, StringBuilder sb, List<String> results) {
        if (sb.length() == digits.length()) {
            results.add(new String(sb.toString()));
            return;
        }

        String temp = ss[digits.charAt(index) - '0'];

        for (int i = 0;i < temp.length();++ i) {
            sb.append(temp.charAt(i));
            combination_helper(ss, digits, index + 1, sb, results);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
