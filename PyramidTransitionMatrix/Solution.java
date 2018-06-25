package PyramidTransitionMatrix;

import java.util.*;

/**
 * We are stacking blocks to form a pyramid. Each block has a color which is a one letter string, like `'Z'`.

 For every block of color `C` we place not in the bottom row, we are placing it on top of a left block of color `A` and right block of color `B`. We are allowed to place the block there only if `(A, B, C)` is an allowed triple.

 We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

 Return true if we can build the pyramid all the way to the top, otherwise false.

 Example 1:
 Input: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 Output: true
 Explanation:
 We can stack the pyramid like this:
 A
 / \
 D   E
 / \ / \
 X   Y   Z

 This works because ('X', 'Y', 'D'), ('Y', 'Z', 'E'), and ('D', 'E', 'A') are allowed triples.
 Example 1:
 Input: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 Output: false
 Explanation:
 We can't stack the pyramid to the top.
 Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 */
public class  Solution {
    int[][] T;
    Set<Long> seen;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        T = new int[7][7];
        seen = new HashSet<>();

        for (String str : allowed) {
            T[str.charAt(0) - 'A'][str.charAt(1) - 'A'] |= 1 << (str.charAt(2) - 'A');
        }

        int N = bottom.length();
        int[][] arr = new int[N][N];

        int t = 0;
        for (char c : bottom.toCharArray()) {
            arr[N - 1][t ++] = c - 'A';
        }

        return solve(arr, 0, N - 1, 0);
    }

    private boolean solve(int[][] arr, long R, int N, int i) {
        if (i == 0 && N == 0) {
            return true;
        } else if (i == N) {
            if (seen.contains(R)) return false;
            seen.add(R);
            return solve(arr, 0, N - 1, 0);
        } else {
            int w = T[arr[N][i]][arr[N][i + 1]];

            for (int b = 0;b < 7;++ b) {
                if (((w >> b) & 1) != 0) {
                    arr[N - 1][i] = b;

                    if (solve(arr, 8 * R + (b + 1), N, i + 1)) return true;
                }
            }
        }

        return false;
    }
}
