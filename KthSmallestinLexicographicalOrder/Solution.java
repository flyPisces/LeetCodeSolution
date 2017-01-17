package KthSmallestinLexicographicalOrder;

/**
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

 Note: 1 ≤ k ≤ n ≤ 109.

 Example:

 Input:
 n: 13   k: 2

 Output:
 10

 Explanation:
 The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

 * Created by aoshen on 10/24/16.
 */
public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k --;

        while (k > 0) {
            int steps = calcSteps(n, curr, curr + 1);

            if (steps <= k) {
                curr ++;
                k = k - steps;
            } else {
                curr = curr * 10;
                k --;
            }
        }

        return curr;
    }

    private int calcSteps(int n,long n1, long n2) {
        int steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 = n1 * 10;
            n2 = n2 * 10;
        }

        return steps;
    }
}
