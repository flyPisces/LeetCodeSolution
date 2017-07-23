package FindtheDerangementofAnArray;

/**
 * In combinatorial mathematics, a derangement is a permutation of the elements of a set,
 * such that no element appears in its original position.

 There's originally an array consisting of n integers from 1 to n in ascending order,
 you need to find the number of derangement it can generate.

 Also, since the answer may be very large, you should return the output mod 109 + 7.

 Example 1:
 Input: 3
 Output: 2
 Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].

 * Created by aoshen on 7/3/17.
 */
public class Solution {
    public int findDerangement(int n) {
        long dn2 = 0, dn1 = 1;
        if (n == 1) return 0;
        else if (n == 2) return 1;

        long res = 0;

        for (int i = 3;i <= n;++ i) {
            res = ((dn1 + dn2) * (i - 1)) % 1000000007;
            dn2 = dn1;
            dn1 = res;
        }

        return (int)res;
    }
}
