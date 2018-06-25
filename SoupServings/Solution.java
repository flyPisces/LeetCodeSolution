package SoupServings;

/**
 * There are two types of soup: type A and type B. Initially we have N ml of each type of soup.
 * There are four kinds of operations:

 Serve 100 ml of soup A and 0 ml of soup B
 Serve 75 ml of soup A and 25 ml of soup B
 Serve 50 ml of soup A and 50 ml of soup B
 Serve 25 ml of soup A and 75 ml of soup B
 When we serve some soup, we give it to someone and we no longer have it.
 Each turn, we will choose from the four operations with equal probability 0.25.
 If the remaining volume of soup is not enough to complete the operation,
 we will serve as much as we can.
 We stop once we no longer have some quantity of both types of soup.

 Note that we do not have the operation where all 100 ml's of soup B are used first.

 Return the probability that soup A will be empty first,
 plus half the probability that A and B become empty at the same time.

 Example:
 Input: N = 50
 Output: 0.625
 Explanation:
 If we choose the first two operations, A will become empty first. For the third operation, A and B will become empty at the same time. For the fourth operation, B will become empty first. So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.

 */
public class Solution {
    public double soupServings(int N) {
        int num = N / 25 + (N % 25 == 0 ? 0 : 1);
        if (num >= 500) return 1.0;
        double[][] dp = new double[num + 1][num + 1];

        for (int s = 0;s <= 2 * num;++ s) {
            for (int i = 0;i <= num;++ i) {
                int j = s - i;
                if (j < 0 || j > num) continue;
                double ans = 0;

                if (i == 0) ans = 1.0;
                if (i == 0 && j == 0) ans = 0.5;
                if (i > 0 && j > 0) {
                    ans = 0.25 * (dp[M(i - 4)][j] + dp[M(i - 3)][M(j - 1)]
                    + dp[M(i - 2)][M(j - 2)] + dp[M(i - 1)][M(j - 3)]);
                }

                dp[i][j] = ans;
            }
        }


        return dp[num][num];
    }

    private int M(int x) {
        return Math.max(x, 0);
    }
}
