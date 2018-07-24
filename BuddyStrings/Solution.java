package BuddyStrings;

/**
 * Given two strings A and B of lowercase letters, return true if and only
 * if we can swap two letters in A so that the result equals B.

 Example 1:

 Input: A = "ab", B = "ba"
 Output: true
 Example 2:

 Input: A = "ab", B = "ab"
 Output: false
 Example 3:

 Input: A = "aa", B = "aa"
 Output: true
 Example 4:

 Input: A = "aaaaaaabc", B = "aaaaaaacb"
 Output: true
 Example 5:

 Input: A = "", B = "aa"
 Output: false
 */
public class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            int[] dp = new int[26];

            for (Character c : A.toCharArray()) {
                dp[c - 'a'] ++;
            }

            for (int i = 0;i < 26;++ i) {
                if (dp[i] > 1) return true;
            }

            return false;
        } else {
            int first = -1, second = -1;

            for (int i = 0;i < A.length();++ i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }

                return second != -1 && A.charAt(first) == B.charAt(second)
                        && A.charAt(second) == B.charAt(first);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.buddyStrings("ab", "ba"));
    }
}
