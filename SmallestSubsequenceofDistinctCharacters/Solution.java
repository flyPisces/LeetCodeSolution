package SmallestSubsequenceofDistinctCharacters;

import java.util.*;

/**
 * Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly once.



 Example 1:

 Input: "cdadabcc"
 Output: "adbc"
 Example 2:

 Input: "abcd"
 Output: "abcd"
 Example 3:

 Input: "ecbacba"
 Output: "eacb"
 Example 4:

 Input: "leetcode"
 Output: "letcod"
 */
public class Solution {
    public String smallestSubsequence(String text) {
        boolean[] visited = new boolean[26];
        int[] last = new int[26];

        for (int i = 0;i < text.length();++ i) {
            last[text.charAt(i) - 'a'] = i;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < text.length();++ i) {
            int diff = text.charAt(i) - 'a';

            if (visited[diff]) continue;

            while (!stack.isEmpty() && stack.peek() > diff && i < last[stack.peek()]) {
                visited[stack.pop()] = false;
            }

            stack.push(diff);
            visited[diff] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }

        return sb.reverse().toString();
    }
}
