package ReverseWordsinaString;

/**
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 * Created by aoshen on 7/5/16.
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] splits = s.split(" ");

        for (int i = splits.length - 1;i >= 0;-- i) {
            if (splits[i].length() != 0) {
                sb.append(splits[i] + " ");
            }
        }

        return sb.length() != 0 ? sb.deleteCharAt(sb.length() - 1).toString() : "";
    }
}
