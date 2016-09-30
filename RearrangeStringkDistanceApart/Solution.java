package RearrangeStringkDistanceApart;

/**
 * Given a non-empty string str and an integer k, rearrange the string such that the same characters are at least distance k from each other.

 All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

 Example 1:
 str = "aabbcc", k = 3

 Result: "abcabc"

 The same letters are at least distance 3 from each other.
 Example 2:
 str = "aaabc", k = 3

 Answer: ""

 It is not possible to rearrange the string.
 Example 3:
 str = "aaadbbcc", k = 2

 Answer: "abacabcd"

 Another possible answer is: "abcabcda"

 The same letters are at least distance 2 from each other.

 * Created by aoshen on 7/31/16.
 */
public class Solution {

    public int nextCharacter(int[] count, int[] valid, int index) {
        int nextCharacterIndex = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0;i < count.length;++ i) {
            if (count[i] > 0 && count[i] > max && valid[i] <= index) {
                max = count[i];
                nextCharacterIndex = i;
            }
        }

        return nextCharacterIndex;
    }

    public String rearrangeString(String str, int k) {
        int[] count = new int[26];
        int[] valid = new int[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < str.length();++ i) {
            count[str.charAt(i) - 'a'] ++;
        }

        for (int i = 0;i < str.length();++ i) {
            int val = nextCharacter(count, valid, i);
            if (val == -1) return "";
            count[val] --;
            valid[val] = i + k;
            sb.append((char)('a' + val));
        }

        return sb.toString();
    }
}
