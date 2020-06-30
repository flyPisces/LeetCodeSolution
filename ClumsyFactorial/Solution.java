package ClumsyFactorial;

/**
 * Normally, the factorial of a positive integer n is the product of all positive integers less than or equal to n.  For example, factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1.

 We instead make a clumsy factorial: using the integers in decreasing order, we swap out the multiply operations for a fixed rotation of operations: multiply (*), divide (/), add (+) and subtract (-) in this order.

 For example, clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1.  However, these operations are still applied using the usual order of operations of arithmetic: we do all multiplication and division steps before any addition or subtraction steps, and multiplication and division steps are processed left to right.

 Additionally, the division that we use is floor division such that 10 * 9 / 8 equals 11.  This guarantees the result is an integer.

 Implement the clumsy function as defined above: given an integer N, it returns the clumsy factorial of N.



 Example 1:

 Input: 4
 Output: 7
 Explanation: 7 = 4 * 3 / 2 + 1
 Example 2:

 Input: 10
 Output: 12
 Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
 */
public class Solution {
    // https://leetcode.com/problems/clumsy-factorial/discuss/252279/You-never-think-of-this-amazing-O(1)-solution
    public int clumsy(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        if (N == 2) return 2;
        if (N == 3) return 6;

        return N * (N - 1) / (N - 2) + helper(N - 3);
    }

    private int helper(int N) {
        if (0 == N) return 0;
        if (1 == N) return 1;
        if (2 == N) return 1;
        if (3 == N) return 1;
        if (4 == N) return -2;
        if (5 == N) return 0;

        return helper((N - 2) % 4 + 2);
    }
}
