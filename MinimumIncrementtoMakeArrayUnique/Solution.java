package MinimumIncrementtoMakeArrayUnique;

import java.util.Arrays;

/**
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

 Return the least number of moves to make every value in A unique.



 Example 1:

 Input: [1,2,2]
 Output: 1
 Explanation:  After 1 move, the array could be [1, 2, 3].
 Example 2:

 Input: [3,2,1,2,1,7]
 Output: 6
 Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 */
public class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int need = 0, result = 0;

        for (int num : A) {
            result += Math.max(need - num, 0);
            need = Math.max(num, need) + 1;
        }

        return result;
    }

    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        int ans = 0, taken = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i-1] == A[i]) {
                taken++;
                ans -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i-1] - 1);
                ans += give * (give + 1) / 2 + give * A[i-1];
                taken -= give;
            }
        }

        if (A.length > 0)
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];

        return ans;
    }
}
