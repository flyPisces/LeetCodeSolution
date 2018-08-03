package NthMagicalNumber;

/**
 * A positive integer is magical if it is divisible by either A or B.

 Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.



 Example 1:

 Input: N = 1, A = 2, B = 3
 Output: 2
 Example 2:

 Input: N = 4, A = 2, B = 3
 Output: 6
 Example 3:

 Input: N = 5, A = 2, B = 4
 Output: 10
 Example 4:

 Input: N = 3, A = 6, B = 4
 Output: 8
 */
public class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        long small = Math.min(A, B), big = Math.max(A, B), lcm = A * B / gcd(small, big);

        long l = 2, h = (long)1e14;

        while (l < h) {
            long mid = l + (h - l) / 2;

            if (mid / A + mid / B - mid / lcm < N) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return (int) (l % (1e9 + 7));

    }

    private long gcd(long small, long big) {
        return small == 0 ? big : gcd(big % small , small);
    }
}
