package ReverseOnlyLetters;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



 Example 1:

 Input: "ab-cd"
 Output: "dc-ba"
 Example 2:

 Input: "a-bC-dEf-ghIj"
 Output: "j-Ih-gfE-dCba"
 Example 3:

 Input: "Test1ng-Leet=code-Q!"
 Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class Solution {
    private boolean notLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return false;
        }

        if (c >= 'A' && c <= 'Z') {
            return false;
        }

        return true;
    }

    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();

        int start = 0, end = S.length() - 1;

        while (start < end) {
            while (start < end && notLetter(S.charAt(start))) {
                ++ start;
            }

            while (start < end && notLetter(S.charAt(end))) {
                -- end;
            }

            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;

            start ++;
            end --;
        }

        return new String(arr);
    }
}
