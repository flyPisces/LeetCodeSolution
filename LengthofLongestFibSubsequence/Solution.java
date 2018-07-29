package LengthofLongestFibSubsequence;

import java.util.*;

/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:

 n >= 3
 X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

 (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)



 Example 1:

 Input: [1,2,3,4,5,6,7,8]
 Output: 5
 Explanation:
 The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 Example 2:

 Input: [1,3,7,11,12,14,18]
 Output: 3
 Explanation:
 The longest subsequence that is fibonacci-like:
 [1,11,12], [3,11,14] or [7,11,18].
 */
public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int x : A) {
            set.add(x);
        }

        int res = 2;

        for (int i = 0;i < A.length;++ i) {
            for (int j = i + 1;j < A.length;++ j) {
                int a = A[i], b = A[j], l = 2;

                while (set.contains(a + b)) {
                    int c = a + b;
                    a = b;
                    b = c;
                    l ++;
                }

                res = Math.max(l, res);
            }
        }

        return res > 2 ? res : 0;
    }
}
