package RemoveAllAdjacentDuplicatesinStringII;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 *
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 *
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 */
public class Solution {
    public String removeDuplicates(String s, int k) {
        int N = s.length(), i = 0, j = 0;
        int[] count = new int[N];
        char[] stack = s.toCharArray();

        for (;j < N;++ i, ++ j) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) {
                i = i - k;
            }
        }

        return new String(stack, 0, i);
    }
}
