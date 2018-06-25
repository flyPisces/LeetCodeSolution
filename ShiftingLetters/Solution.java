package ShiftingLetters;

/**
 * We have a string S of lowercase letters, and an integer array shifts.

 Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

 For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

 Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.

 Return the final string after all such shifts to S are applied.

 Example 1:

 Input: S = "abc", shifts = [3,5,9]
 Output: "rpl"
 Explanation:
 We start with "abc".
 After shifting the first 1 letters of S by 3, we have "dbc".
 After shifting the first 2 letters of S by 5, we have "igc".
 After shifting the first 3 letters of S by 9, we have "rpl", the answer
 */
public class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = S.length() - 1;i >= 0;-- i) {
            sum = (sum + shifts[i]) % 26;
            char c = (char) (sum + S.charAt(i));
            if (c > 'z') {
                c = (char) (c - 26);
            }
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        sol.shiftingLetters("abc", new int[] {3, 5, 9});
    }
}
