package MaximumNumberofOnes;

import java.util.*;

/**
 * Consider a matrix M with dimensions width * height, such that every cell has value 0 or 1, and any square sub-matrix of M of size sideLength * sideLength has at most maxOnes ones.
 *
 * Return the maximum possible number of ones that the matrix M can have.
 *
 *
 *
 * Example 1:
 *
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 1
 * Output: 4
 * Explanation:
 * In a 3*3 matrix, no 2*2 sub-matrix can have more than 1 one.
 * The best solution that has 4 ones is:
 * [1,0,1]
 * [0,0,0]
 * [1,0,1]
 * Example 2:
 *
 * Input: width = 3, height = 3, sideLength = 2, maxOnes = 2
 * Output: 6
 * Explanation:
 * [1,0,1]
 * [1,0,1]
 * [1,0,1]
 */
public class Solution {
    //https://leetcode.com/problems/maximum-number-of-ones/discuss/377099/C%2B%2B-solution-with-explanation

    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] dp = new int[sideLength][sideLength];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = 0;i < height;++ i) {
            for (int j = 0;j < width;++ j) {
                dp[i % sideLength][j % sideLength] ++;
            }
        }

        for (int i = 0;i < sideLength;++ i) {
            for (int j = 0; j < sideLength; ++j) {
                pq.offer(dp[i][j]);
            }
        }

        int sum = 0;

        for (int i = 0;i < maxOnes;++ i) {
            sum += pq.poll();
        }

        return sum;
    }

}
