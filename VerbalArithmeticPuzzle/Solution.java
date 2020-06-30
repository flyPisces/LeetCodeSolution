package VerbalArithmeticPuzzle;

import java.util.*;

/**
 * Given an equation, represented by words on left side and the result on right side.
 *
 * You need to check if the equation is solvable under the following rules:
 *
 * Each character is decoded as one digit (0 - 9).
 * Every pair of different characters they must map to different digits.
 * Each words[i] and result are decoded as one number without leading zeros.
 * Sum of numbers on left side (words) will equal to the number on right side (result).
 * Return True if the equation is solvable otherwise return False.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["SEND","MORE"], result = "MONEY"
 * Output: true
 * Explanation: Map 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
 * Such that: "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
 * Example 2:
 *
 * Input: words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
 * Output: true
 * Explanation: Map 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
 * Such that: "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
 * Example 3:
 *
 * Input: words = ["THIS","IS","TOO"], result = "FUNNY"
 * Output: true
 * Example 4:
 *
 * Input: words = ["LEET","CODE"], result = "POINT"
 * Output: false
 */
public class Solution {
    private static int[] POW_10 = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000};

    public boolean isSolvable(String[] words, String result) {
        Set<Character> charSet = new HashSet<>();
        boolean[] noleadingZero = new boolean[100];
        int[] charCount = new int[100];

        for (String word : words) {
            for (int i = 0;i < word.length();++ i) {
                if (i == 0 && word.length() > 1) noleadingZero[word.charAt(i)] = true;
                charSet.add(word.charAt(i));
                charCount[word.charAt(i)] += POW_10[word.length() - i - 1];
            }
        }

        for (int i = 0;i < result.length();++ i) {
            if (i == 0 && result.length() > 1) noleadingZero[result.charAt(i)] = true;
            charSet.add(result.charAt(i));
            charCount[result.charAt(i)] -= POW_10[result.length() - 1 - i];
        }

        boolean[] used = new boolean[10];
        char[] charList = new char[charSet.size()];

        int idx = 0;
        for (char c : charSet) charList[idx ++] = c;

        return backtracking(used, noleadingZero, charList, 0, 0, charCount);
    }

    private boolean backtracking(boolean[] used, boolean[] noleadingZero, char[] charList, int step, int diff, int[] charcount) {
        if (step == charList.length) return diff == 0;
        for (int d = 0;d <= 9;++ d) {
            char c = charList[step];

            if (!used[d] && (d > 0 || !noleadingZero[c])) {
                used[d] = true;

                if (backtracking(used, noleadingZero, charList, step + 1, diff + charcount[c] * d, charcount)) return true;

                used[d] = false;
            }
        }

        return false;
    }
}
