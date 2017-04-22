package ReverseWordsinaStringThree;

/**
 * Total Accepted: 6784
 Total Submissions: 10697
 Difficulty: Easy
 Contributors:
 joshpowell
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.

 * Created by aoshen on 4/16/17.
 */
public class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0;i < arr.length;++ i) {
            if (arr[i] != ' ') {
                int j = i;
                while (j + 1 < arr.length && arr[j + 1] != ' ') ++ j;
                swap(arr, i, j);
                i = j;
            }
        }

        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        for (;i < j;++ i, -- j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
