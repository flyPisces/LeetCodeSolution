package FindNUniqueIntegersSumuptoZero;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 */
public class Solution {
    public int[] sumZero(int n) {
        if (n == 1) return new int[] {0};

        int[] res = new int[n];

        if (n % 2 == 0) {
            int start = 0, end = n - 1;

            int num = 1;
            while (start < end) {
                res[start ++] = num;
                res[end --] = -num;

                ++ num;
            }
        } else {
            res[0] = 0;
            res[1] = 1;
            res[n - 1] = -1;

            int start = 2, end = n - 2, num = 2;
            while (start < end) {
                res[start ++] = num;
                res[end --] = -num;

                ++ num;
            }
        }

        return res;
    }
}
